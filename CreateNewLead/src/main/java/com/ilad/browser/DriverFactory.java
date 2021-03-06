package com.ilad.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * A driver factory for the WebDriver object. Currently supports the Firefox
 * driver, Chrome driver, and HTMLUnit driver
 * @author Shlomi Reuveni
 * @since Dec 23 2015
 */
public class DriverFactory {
	/**
	 * An Enum for the DriverFactory class. Used to determine the WebDriver instance
	 * type received from the factory
	 * @author Shlomi Reuveni
	 * @since Dec 28 2015
	 */
	public enum DriverType {
		CHROME, FIREFOX, HTMLUNIT
	}
	/**
	 * Returns an instance of the requested WebDriver. Null in case of an
	 * invalid name
	 * @param browser the name of the requested driver
	 * @return if the requested driver is valid, returns an instant of the
	 * requested driver. If the requested driver is invalid, null is returned.
	 */
	public static WebDriver getDriver(DriverType browser) {
		WebDriver driver = null;

		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					"/home/developer/Downloads/chromedriver");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case HTMLUNIT:
			driver = new HtmlUnitDriver();
			break;
		default:
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
