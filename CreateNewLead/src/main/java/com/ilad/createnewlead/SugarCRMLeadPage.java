package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the lead page in a SugarCRM account
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public class SugarCRMLeadPage extends AbstractSugarCRMPage {
	/**
	 * A constructor
	 * @param driver the driver used to manipulate the page
	 */
	public SugarCRMLeadPage(WebDriver driver) {
		super(driver);
		Assert.assertTrue(actionbot.isPage(By.id("search_form")));
	}

	/**
	 * Checks if the current page is the lead page
	 * @return true if the current page is the lead page; otherwise false
	 */
	public boolean isLeadPage() {
		return actionbot.isPage(By.id("search_form"));
	}

	/**
	 * Used in the lead page to create a new lead
	 * @return a new SugarCRMCreateLead instance
	 */
	public SugarCRMCreateLead clickOnCreateList() {
		actionbot.click(By.xpath("//img[@alt='Create Lead']"));
		return new SugarCRMCreateLead(m_driver);
	}

	/**
	 * Search the leads in the lead page for the specified lead. Note that this
	 * method does <em>not</em> check if the lead is present. The method
	 * isLeadPresent is used for that
	 * @param firstName the first name of the lead
	 * @param lastName the last name of the lead
	 */
	public void searchLeadForm(String firstName, String lastName) {
		actionbot.type(By.id("search_name_basic"), firstName + " " + lastName);
		actionbot.click(By.id("search_form_submit"));
	}

	/**
	 * Checks if the lead is present in the lead page. Note that this method
	 * does <em>not</em> search the lead page. the method searchLeadForm is
	 * used for that
	 * @param firstName the first name of the lead
	 * @param lastName the last name of the lead
	 * @return true if the lead is present; otherwise false
	 */
	public boolean isLeadPresent(String firstName, String lastName) {
		By LeadXpath = By.xpath("//table[@class='list view']/descendant::"
				+ "a[contains(text(),'" + firstName + " " + lastName + "')]");
		return actionbot.isElementPresent(LeadXpath);
	}

}
