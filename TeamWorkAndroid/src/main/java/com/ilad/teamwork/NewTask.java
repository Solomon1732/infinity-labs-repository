package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class NewTask extends AbstractLoggedIn {

	public NewTask(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	@Override
	public TaskList navigateUp() {
		driver.findElementByAccessibilityId("Navigate up").click();
		return new TaskList(driver);
	}

	public void addTitle(String firstTaskTitle) {
		WebElement element = driver.findElementByXPath("//android.widget.EditText"
				+ "[@text='Title accepts #tag or #[big tag]']");
		this.type(element, firstTaskTitle, false);
	}

	public void addDescription(String firstTaskDescription) {
		WebElement element = driver.findElementByXPath("//android.widget.EditText"
				+ "[@text='Description']");
		this.type(element, firstTaskDescription, false);
	}

	public TaskList save() {
		driver.findElementByAccessibilityId("Save").click();
		return new TaskList(driver);
	}

}
