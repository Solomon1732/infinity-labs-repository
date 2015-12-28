package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the tasks page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class TasksPage extends AbstractTopQPage {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public TasksPage(WebDriver driver_) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(By.xpath("//a[./text()='Tasks']")));
	}

	/**
	 * Click on the add task list button
	 * @return an NewTaskList object instance
	 */
	public NewTaskList addTaskList() {
		actionbot.click(By.id("liBFOATL"));
		return new NewTaskList(m_driver);
	}

	/**
	 * Checks whether a particular task exist
	 * @param taskListName the name of the task list to be verified
	 * @return true if the task list is found; otherwise false
	 */
	public boolean doesTaskExist(String taskListName) {
		return actionbot.isElementPresent(By.xpath("//a[/text='" + taskListName + "']"));
	}

	/**
	 * Click on the link of a task list to the page for managing the task list
	 * @param taskListName the task list name
	 * @return an TaskListManagementPage object instance
	 */
	public TaskListManagementPage clickOnLinkToTaskListPage(String taskListName) {
		actionbot.click(By.xpath("//a[./text()='" + taskListName + "']"));
		return new TaskListManagementPage(m_driver, taskListName);
	}

}
