package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TaskList extends AbstractLoggedIn {

	public TaskList(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	@Override
	public TabsMenu navigateUp() {
		WebElement element = driver.findElementByAccessibilityId("Navigate up");
		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}

	public TaskListOptions listOptions() {
		driver.findElementByAccessibilityId("More options").click();

		return new TaskListOptions(driver);
	}

	public boolean isTaskExist(String taskTitle) {
		return !driver.findElementsByXPath("//android.widget.TextView"
				+ "[@text='" + taskTitle + "']").isEmpty();
	}
}
