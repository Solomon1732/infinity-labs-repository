package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the login page in a SugarCRM account
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public class SugarCRMLogin extends AbstractSugarCRMPage {
	/**
	 * Username locator
	 */
	private By usernameID = By.id("user_name");
	/**
	 * Password locator
	 */
	private By passwordID = By.id("user_password");
	/**
	 * Login button locator
	 */
	private By loginButtonID = By.id("login_button");

	/**
	 * A constructor for the specified WebDriver
	 * @param driver the driver used to manipulate the page
	 */
	public SugarCRMLogin(WebDriver driver) {
		super(driver);
		Assert.assertTrue(actionbot.isPage(loginButtonID));
	}

	/**
	 * Checks if the page is the login page
	 * @return true if login page; otherwise false
	 */
	public boolean isLoginPage() {
		return actionbot.isPage(loginButtonID);
	}

	/**
	 * Logs in the account
	 * @param username_ the username of the account
	 * @param password_ the password of the account
	 * @return a new SugarCRMHomePage instance
	 */
	public SugarCRMHomePage submitLogin(String username_, String password_) {
		actionbot.type(usernameID, username_);
		actionbot.type(passwordID, password_);
		actionbot.submit(loginButtonID);
		return new SugarCRMHomePage(m_driver);
	}

	/**
	 * Used for testing purposes to check the case of a failed login attempt
	 * @return the same SugarCRMLogin instance
	 */
	public SugarCRMLogin submitLoginExpectingFailure() {
		actionbot.submit(loginButtonID);
		return this;
	}
}
