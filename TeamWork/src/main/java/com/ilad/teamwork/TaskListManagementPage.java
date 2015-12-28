package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the task list management page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class TaskListManagementPage extends AbstractTopQPage {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 * @param taskListName the name of the task list
	 */
	public TaskListManagementPage(WebDriver driver_, String taskListName) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(By.xpath("//a[./text()='"
				+ taskListName + "']")));
	}

	/**
	 * click on the add task button
	 * @return an AddTaskPage object instance
	 */
	public AddTaskPage clickOnAddTaskButton() {
		actionbot.click(By.xpath("//li[@id='liBFOATL']/../"
				+ "descendant::span[@class='btn-addIcon']"));
		return new AddTaskPage(m_driver);
	}

	/**
	 * Checks whether the task exist
	 * @param taskName the task name to be checked 
	 * @return true if the task exist; otherwise false
	 */
	public boolean isTaskExists(String taskName) {
		return actionbot.isElementPresent(By.xpath("//span[./text()='"
				+ taskName + "']"));
	}

	/**
	 * Opens the options mini-page for the task list
	 * @return an TaskListOptions object instance
	 */
	public TaskListOptions openListOptions() {
		actionbot.click(By.className("ico-project-options"));
		return new TaskListOptions(m_driver);
	}
}
