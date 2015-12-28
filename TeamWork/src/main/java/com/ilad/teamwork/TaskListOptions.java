package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * A page handler for the task list options mini-page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class TaskListOptions extends AbstractTopQPage {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public TaskListOptions(WebDriver driver_) {
		super(driver_);
	}

	/**
	 * Click on the delete option to delete the task list
	 * @return an TaskPage object instance
	 */
	public TasksPage clickToDeleteTaskList() {
		actionbot.click(By.xpath("//i[@class='ico-trash icon-large']/.."));
		return new TasksPage(m_driver);
	}

}
