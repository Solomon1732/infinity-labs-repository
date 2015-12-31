package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AllProjectsPage extends AbstractLoggedIn {

	public AllProjectsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public ProjectHomePage selectProject(String projectName) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='" + projectName + "']");
		driver.tap(1, element, 100);
		return new ProjectHomePage(driver);
	}

	@Override
	public AbstractLoggedIn navigateUp() {
		WebElement element = driver.findElementByAccessibilityId("Navigate up");
		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}
}
