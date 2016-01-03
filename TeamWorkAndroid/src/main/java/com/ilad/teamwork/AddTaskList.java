package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import com.ilad.teamwork.AbstractLoggedIn;
import com.ilad.teamwork.ActiveTaskListsPage;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskList extends AbstractLoggedIn {

	public AddTaskList(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public void addTitle(String title) {
		WebElement element = driver.findElementByXPath("//android.widget.EditText"
				+ "[@text='Title']");
		this.type(element, title, false);
	}

	public void addDescription(String description) {
		WebElement element = driver.findElementByXPath("//android.widget.EditText"
				+ "[@text='Description']");
		this.type(element, description, false);
	}
	
	@Override
	public ActiveTaskListsPage navigateUp() {
		driver.findElementByAccessibilityId("Navigate up").click();
		return new ActiveTaskListsPage(driver);
	}

	public ActiveTaskListsPage saveList() {
		driver.findElementByAccessibilityId("Save").click();
		return new ActiveTaskListsPage(driver);
	}
}
