package com.ilad.testcreatenewlead;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ilad.browser.DriverFactory;
import com.ilad.createnewlead.SalesSubMenuPage;
import com.ilad.createnewlead.SugarCRMCreateLead;
import com.ilad.createnewlead.SugarCRMHomePage;
import com.ilad.createnewlead.SugarCRMLeadPage;
import com.ilad.createnewlead.SugarCRMLogin;

@Listeners({com.ilad.testcreatenewlead.TestListener.class})
public class TestCreateNewLead {
	private WebDriver driver = DriverFactory.getDriver(DriverFactory.DriverType.CHROME);
	private SugarCRMLogin LoginPage;
	private static final String username = "admin";
	private static final String password = "admin";
	private static final String salutation = "Dr.";
	private static final String firstName = "Dietrich";
	private final String lastName = Long.toString(System.currentTimeMillis());

	@BeforeTest
	public void setup() {
		driver.get("http://localhost/sugar");
	}

	@AfterTest
	public void closePage() {
		LoginPage.closePage();
	}

	@Test(description = "Tests a case of a failed login attempt")
	public void testFailedLogin() {
		LoginPage = new SugarCRMLogin(driver);
		Assert.assertEquals(LoginPage, LoginPage.submitLoginExpectingFailure());
	}

	@Test(description = "Tests the creation of a lead and a confirmation of"
			+ " its successfull creation", dependsOnMethods = {"testFailedLogin"})
	public void testCreation() {
		//Login
		LoginPage = new SugarCRMLogin(driver);

		//Go to home page
		SugarCRMHomePage homePage = LoginPage.submitLogin(username, password);

		//Go to leads page
		SalesSubMenuPage salesSubMenuPage = homePage.clickOnSalesItem();
		SugarCRMLeadPage searchLeadsPage = salesSubMenuPage.clickOnLeadsMenuItem();

		//Create lead
		SugarCRMCreateLead CreateLead = searchLeadsPage.clickOnCreateList();
		boolean checkBox = true;
		CreateLead.fillFields(firstName, lastName, salutation, checkBox);
		CreateLead.saveLead();

		//Check that the lead is in the leads list
		searchLeadsPage = salesSubMenuPage.clickOnLeadsMenuItem();
		searchLeadsPage.searchLeadForm(firstName, lastName);
		Assert.assertTrue(searchLeadsPage.isLeadPresent(firstName, lastName));

		//Check case of non-existing lead
		searchLeadsPage.searchLeadForm(firstName, lastName + "0xDeadBeef");
		Assert.assertFalse(searchLeadsPage.isLeadPresent(firstName, lastName));
		searchLeadsPage.logout();
	}
}
