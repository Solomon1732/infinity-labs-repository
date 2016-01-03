package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ActiveTaskListsPage extends AbstractListTypes {

	public ActiveTaskListsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AddTaskList addTaskList(String taskListName) {

		scrollDownToElement("//android.widget.TextView"
				+ "[@text='Add Task List']", 5000).click();
		return new AddTaskList(driver);
	}

	public TaskList selectTaskList(String taskListName) {		
		scrollDownToElement("//android.widget.TextView"
				+ "[@text='" + taskListName + "']", 5000).click();
		
		return new TaskList(driver);
	}
}
