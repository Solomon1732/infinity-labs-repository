package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmTaskDeletion extends AbstractTeamWork {

	public ConfirmTaskDeletion(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public ActiveTaskListsPage delete() {
		driver.findElementByXPath("//android.widget.Button[@text='Delete']").click();
		return new ActiveTaskListsPage(driver);
	}

}
