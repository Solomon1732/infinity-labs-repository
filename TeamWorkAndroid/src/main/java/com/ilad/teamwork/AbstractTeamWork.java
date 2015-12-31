package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import com.ilad.androidphone.AbstractAndroidPageObject;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractTeamWork extends AbstractAndroidPageObject {

	public AbstractTeamWork(AndroidDriver<WebElement> driver) {
		super(driver);
	}	
}
