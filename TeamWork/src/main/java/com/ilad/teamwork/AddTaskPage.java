package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page-handler for the 'add task' mini-page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */

public class AddTaskPage extends AbstractTopQPage {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public AddTaskPage(WebDriver driver_) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(By.xpath("//input[@placeholder="
				+ "'What needs to be done?']")));
	}

	/**
	 * Type in the new task name
	 * @param taskName the name of the task to be added
	 */
	public void sendkeysTaskName(String taskName) {
		actionbot.type(By.xpath("//span/input[@placeholder='What needs to be done?']"),
				taskName);
	}

	/**
	 * Submit the new task to the task list
	 */
	public void submitTask() {
		actionbot.submit(By.xpath("//div[@id='editTaskFormFooter0']/input"));
	}

	/**
	 * Select who should do the task
	 * @param whoShouldDoTheTask the account that should do the task
	 */
	public void selectWhoShouldDoThis(String whoShouldDoTheTask) {
		actionbot.selectByVisibleText(By.name("taskAssignedToUserId"), whoShouldDoTheTask);
	}

}
