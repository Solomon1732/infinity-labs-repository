package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ProjectHomePage extends AbstractLoggedIn {

	public ProjectHomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	@Override
	public TabsMenu navigateUp() {
		WebElement element = driver.findElementByAccessibilityId("Navigate up");
		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}

	public ActiveTaskListsPage goToTasks() {
		driver.findElementByXPath("//android.widget.TextView[@text='Tasks']"
				+ "/../descendant::android.widget.Button").click();
		return new ActiveTaskListsPage(driver);
	}

}
