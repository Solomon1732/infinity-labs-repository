package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ilad.browser.AbstractPageObject;

/**
 * An abstract SugaCRM page object
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public abstract class AbstractSugarCRMPage extends AbstractPageObject {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public AbstractSugarCRMPage(WebDriver driver_) {
		super(driver_);
	}

	/**
	 * Logging out of the account
	 */
	public void logout() {
		actionbot.click(By.id("logout_link"));
	}
}
