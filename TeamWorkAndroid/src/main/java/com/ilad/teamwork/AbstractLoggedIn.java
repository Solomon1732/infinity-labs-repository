package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractLoggedIn extends AbstractTeamWork {

	public AbstractLoggedIn(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * @return an AbstractTeamWork instance
	 */
	public abstract AbstractTeamWork navigateUp();
}
