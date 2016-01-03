package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AllActivityPage extends AbstractLoggedIn {

	public AllActivityPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	/**
	 * @return a TabsMenu object instant. Add a casting to TabsMenu
	 */
	@Override
	public TabsMenu navigateUp() {
		driver.findElementByAccessibilityId("Navigate up").click();
		return new TabsMenu(driver);
	}
}
