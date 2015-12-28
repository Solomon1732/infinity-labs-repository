package com.ilad.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * An actionbot
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public class ActionBot {
	private final WebDriver m_driver;

	/**
	 * A constructor for the actionbot
	 * @param driver_ the Webdriver instance used by the actionbot to manipulate
	 * pages
	 */
	public ActionBot(WebDriver driver_) {
		m_driver = driver_;
	}

	/**
	 * Click on an element specified by the locator
	 * @param locator the locator of the element to be clicked
	 */
	public void click(By locator) {
		m_driver.findElement(locator).click();
	}

	/**
	 * Submit an element (usually by clicking on it)
	 * @param locator the locator of the element to be submitted
	 */
	public void submit(By locator) {
		m_driver.findElement(locator).submit();
	}

	/**
	 * Locates an element in the page
	 * @param locator the locator of the element to be located
	 * @return the element found
	 */
	public WebElement findElement(By locator) {
		return m_driver.findElement(locator);
	}

	/**
	 * A method to check if the current page is a page containing the element
	 * @param locator a locator to check if the current page is the page the
	 * element is located in
	 * @return true if the element is found; otherwise false
	 * <br><b>Note:</b> if the element is not a unique element (e.g. tagName)
	 * it may result in undefined behavior
	 */
	public boolean isPage(By locator) {
		return !m_driver.findElements(locator).isEmpty();
	}

	/**
	 * Used to locate and select an element in a page (for example, in a table
	 * in the page)
	 * @param locator the locator of the element to be selected
	 * @param value a String that is the value to be selected
	 */
	public void selectByValue(By locator, String value) {
		new Select(m_driver.findElement(locator)).selectByValue(value);
	}
	
	/**
	 * Used to locate and select an element in a page (for example, in a table
	 * in the page)
	 * @param locator the locator of the element to be selected
	 * @param text a String containing the visible text of the option to be
	 * selected
	 */
	public void selectByVisibleText(By locator, String text) {
		new Select(m_driver.findElement(locator)).selectByVisibleText(text);;
	}
	
	/**
	 * Type something into an input field. WebDriver doesn't normally clear these
	 * before typing, so this method does that first.
	 * @param locator the locator of the element to be typed into (e.g. search
	 * bar)
	 * @param text the text to be written into the element
	 */
	public void type(By locator, String text) { 
		WebElement element = m_driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Checks if the element specified by the locator parameter exists in the
	 * page
	 * @param locator the locator of the element to be located
	 * @return true if the element is located; otherwise false
	 */
	public boolean isElementPresent(By locator) {
		return this.isPage(locator);
	}

	/**
	 * Quit the driver instant
	 */
	public void quit() {
		m_driver.quit();
	}
}
