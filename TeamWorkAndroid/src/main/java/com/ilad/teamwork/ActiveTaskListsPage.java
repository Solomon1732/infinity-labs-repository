package com.ilad.teamwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.ilad.testteamworkmobile.AddTaskList;

import io.appium.java_client.android.AndroidDriver;

public class ActiveTaskListsPage extends AbstractLoggedIn {

	public ActiveTaskListsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	@Override
	public AbstractLoggedIn navigateUp() {
		WebElement element = driver.findElementByAccessibilityId("Navigate up");
		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}

	public AddTaskList addTaskList(String taskListName) {
		Dimension pageSize = driver.manage().window().getSize();
		int width = pageSize.width / 2;
		int startingHeight = pageSize.height * 9 / 10;
		int endingHeight = pageSize.height / 10;

		this.implicitwait(0, TimeUnit.SECONDS);

		while(driver.findElementsByXPath("//android.widget.TextView"
				+ "[@text='Add Task List']").isEmpty()) {
			driver.swipe(width, startingHeight, width, endingHeight, 1500);
		}

		this.implicitwait(30, TimeUnit.SECONDS);

		WebElement element =driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='Add Task List']");
		driver.tap(1, element, 100);

		return new AddTaskList(driver);
	}

}
