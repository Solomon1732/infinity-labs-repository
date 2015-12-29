package com.ilad.browser;

import org.openqa.selenium.WebDriver;

/**
 * An abstract page object class
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public abstract class AbstractPageObject {
	/**
	 * A web driver instance
	 */
	protected WebDriver m_driver;
	/**
	 * An actionbot instance
	 */
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
	 * Close the window. Quits the driver instance if it's the last window
	 * currently open
	 */
	public void closeWindow() {
		m_driver.close();
	}
	
	/**
	 * Closes all the windows and quit the the driver instance
	 */
	public void quit() {
		actionbot.quit();
	}
}
