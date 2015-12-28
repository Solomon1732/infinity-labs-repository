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
	 * Returns an instance of the requested WebDriver. Null in case of an
	 * invalid name
	 * <br>Valid names are: "HtmlUnit", "Chrome", and "Firefox". The names are
	 * not case sensitive
	 * @param driverType the name of the requested driver
	 * @return if the requested driver is valid, returns an instant of the
	 * requested driver. If the requested driver is invalid, null is returned.
	 */
	public static WebDriver getDriver(String driverType) {
		WebDriver driver = null;

		if(driverType.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/developer/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if(driverType.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if(driverType.equalsIgnoreCase("HTMLUNIT")) {
			driver = new HtmlUnitDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
