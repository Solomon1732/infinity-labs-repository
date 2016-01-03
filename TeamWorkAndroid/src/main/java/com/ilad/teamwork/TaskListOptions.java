package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TaskListOptions extends AbstractTeamWork {

	public TaskListOptions(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public NewTask addTask() {
		driver.findElementByXPath("//android.widget.TextView[@text='Add']").click();
		return new NewTask(driver);
	}

	public ConfirmTaskDeletion deleteTaskList() {
		driver.findElementByXPath("//android.widget.TextView[@text='Delete']").click();
		return new ConfirmTaskDeletion(driver);
	}
}
