package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the new task list mini-page opened when the add task list
 * button is pressed
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */

public class NewTaskList extends AbstractTopQPage{
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public NewTaskList(WebDriver driver_) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(By.id("newTaskListName")));
	}

	/**
	 * Type the task list name
	 * @param taskListName the task list
	 */
	public void sendkeysTaskListName(String taskListName) {
		actionbot.type(By.id("newTaskListName"), taskListName);
	}

	/**
	 * Submit the task list
	 * @return A TaskPage object instance
	 */
	public TasksPage submitTaskList() {
		actionbot.submit(By.id("btnCreateTaskList"));
		return new TasksPage(m_driver);
	}

}
