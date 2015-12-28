package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the home page in a SugarCRM account
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public class SugarCRMHomePage extends AbstractSugarCRMPage {
	/**
	 * A constructor
	 * @param driver the WebDriver used to manipulate the home page
	 */
	public SugarCRMHomePage(WebDriver driver) {
		super(driver);
		Assert.assertTrue(actionbot.isPage(By.id("pageNum_0_div")));
	}

	/**
	 * Checks whether the current page is the home page
	 * @return true if the current page is the home page; otherwise false
	 */
	public boolean isHomePage() {
		return actionbot.isPage(By.id("pageNum_0_div"));
	}

	/**
	 * Click on the sales tab and return an instant of the sub-menu
	 * @return an instance of the sales sub-menu
	 */
	public SalesSubMenuPage clickOnSalesItem() {
		return new SalesSubMenuPage(m_driver);
	}

}
