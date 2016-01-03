package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ListFilter extends AbstractTeamWork {	

	public ListFilter(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	/**
	 * @deprecated not fully implemented
	 * @param typeOfTaskLists
	 * @return
	 */
	public AbstractListTypes chooseTaskListsType(TaskListsFilter typeOfTaskLists) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='" + typeOfTaskLists.getTaskListsFilterValue() + "']");
		driver.tap(1, element, 100);
		
		switch (typeOfTaskLists) {
		case ACTIVE_TASK_LIST_FILTER:
			return new ActiveTaskListsPage(driver);
		case COMPETED_TASK_LISTS:
			return new CompletedTaskListsPage(driver);
		default:
			return null;
		}
	}
	
	
	public enum TaskListsFilter {
		COMPETED_TASK_LISTS("Completed Task Lists"),
		ACTIVE_TASK_LIST_FILTER("Active Task Lists");
		
		private final String value;
		
		private TaskListsFilter(final String value) {
			this.value = value;
		}
		
		public String getTaskListsFilterValue() {
			return value;
		}
	}
}
