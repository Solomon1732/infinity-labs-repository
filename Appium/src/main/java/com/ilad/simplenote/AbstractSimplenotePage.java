package com.ilad.simplenote;

import org.openqa.selenium.WebElement;

import com.ilad.androidphone.AbstractAndroidPageObject;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractSimplenotePage extends AbstractAndroidPageObject {

	public AbstractSimplenotePage(final AndroidDriver<WebElement> driver) {
		super(driver);
	}

}
