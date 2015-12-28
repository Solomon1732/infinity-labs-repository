package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the login page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class LoginPage extends AbstractTopQPage {
	/**
	 * Username locator
	 */
	private By m_username = By.id("userLogin");

	/**
	 * Password locator
	 */
	private By m_password = By.id("password");
	
	/**
	 * Login button locator
	 */
	private By m_loginButton = By.id("ordLoginSubmitBtn");
	
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public LoginPage(WebDriver driver_) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(m_username));
	}

	/**
	 * Enter the username
	 * @param username_ the username to be entered
	 */
	public void sendKeysToUsername(String username_) {
		actionbot.type(m_username, username_);
	}
	
	/**
	 * Enter the password
	 * @param password_ the password to be entered
	 */
	public void sendKeysToPassword(String password_) {
		actionbot.type(m_password, password_);		
	}
	
	/**
	 * Click on the login button
	 */
	private void clickOnLoginButton() {
		actionbot.click(m_loginButton);
	}
	
	/**
	 * Submit a login for an expected failed login. The method doesn't enter a
	 * password when attempting a login, therefore it doesn't accept the
	 * password, only the username
	 * @param username_ the username to be entered
	 * @return the same LoginPage object
	 */
	public Object submitLoginExpectingFailure(String username_) {
		actionbot.click(m_loginButton);
		return this;
	}

	/**
	 * Submit a login while expecting a successful attempt
	 * @param username_ the username of the account
	 * @param password_ the password for the account
	 * @return an OverviewPage object instant
	 */
	public OverviewPage submitLogin(String username_, String password_) {
		this.sendKeysToUsername(username_);
		this.sendKeysToPassword(password_);
		this.clickOnLoginButton();
		return new OverviewPage(m_driver);
	}
}
