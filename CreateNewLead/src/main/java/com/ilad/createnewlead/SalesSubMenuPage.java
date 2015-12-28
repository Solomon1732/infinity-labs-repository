package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This object is used to navigate the sales sub-menu
 * @author developer
 * @since Dec 23 2015
 */
public class SalesSubMenuPage extends AbstractSugarCRMPage {

	/**
	 * A constructor
	 * @param driver_ the WebDriver used to manipulate the sales sub-menu page
	 */
	public SalesSubMenuPage(WebDriver driver_) {
		super(driver_);
	}

	/**
	 * Go to the lead page option in the sub-menu and return an instance of
	 * that page
	 * @return an instant of the lead page
	 */
	public SugarCRMLeadPage clickOnLeadsMenuItem() {
		actionbot.click(By.id("moduleTab_0_Leads"));
		return new SugarCRMLeadPage(m_driver);
	}

}
