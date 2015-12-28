package com.ilad.browser;

import org.openqa.selenium.WebDriver;

/**
 * An abstract page object class
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public abstract class AbstractPageObject {
	protected WebDriver m_driver;
	protected ActionBot actionbot;

	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public AbstractPageObject(WebDriver driver_) {
		m_driver = driver_;
		actionbot = new ActionBot(driver_);
	}

	/**
	 * Close the page opened by the driver
	 */
	public void closePage() {
		actionbot.quit();
	}
}
