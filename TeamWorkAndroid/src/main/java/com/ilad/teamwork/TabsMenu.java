package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TabsMenu extends AbstractLoggedIn {

	public TabsMenu(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public AllProjectsPage goToProjects() {
		WebElement element = driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='Projects']");
		driver.tap(1, element, 100);
		return new AllProjectsPage(driver);
	}

	/**
	 * @deprecated has no effect
	 */
	@Override
	public AbstractLoggedIn navigateUp() {
		return null;
	}

}
