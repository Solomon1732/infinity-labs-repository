package com.ilad.testteamwork;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ilad.browser.DriverFactory;
import com.ilad.teamwork.AddTaskPage;
import com.ilad.teamwork.LoginPage;
import com.ilad.teamwork.NewTaskList;
import com.ilad.teamwork.OverviewPage;
import com.ilad.teamwork.TaskListManagementPage;
import com.ilad.teamwork.TaskListOptions;
import com.ilad.teamwork.TasksPage;

public class TestAddTask {
	private WebDriver driver = DriverFactory.getDriver("Firefox");
	private LoginPage login;
	private static final String username = "fake06";
	private static final String password = "fake";
	private final String taskListName = "Bloosy task list"
			+ Long.toString(System.currentTimeMillis());

	@BeforeTest
	public void setup() {
		driver.get("https://topq.teamwork.com");
	}

	@AfterTest
	public void quit() {
		login.closePage();
	}

	@Test(description = "Tests a case of a failed login attempt")
	public void testFailedLogin() {
		login = new LoginPage(driver);
		Assert.assertEquals(login.submitLoginExpectingFailure(username), login);
	}

	@Test(description = "Tests a case of adding a task to a task list",
			dependsOnMethods = {"testFailedLogin"})
	public void testAddTaskToList() {
		login = new LoginPage(driver);

		Reporter.log("<p>Logging in</p>");
		OverviewPage overview = login.submitLogin(username, password);

		Reporter.log("Going to task list page");
		TasksPage tasks = overview.clickOnTasksItem();

		Reporter.log("<p>Adding a task list</p>");
		this.sleep(2000);
		NewTaskList newTaskModule = tasks.addTaskList();
/*		final String taskListName = "Bloody task list"
				+ Long.toString(System.currentTimeMillis());*/
		newTaskModule.sendkeysTaskListName(taskListName);
		tasks = newTaskModule.submitTaskList();

		Reporter.log("<p>Adding tasks</p>");
		TaskListManagementPage taskListPage = tasks.clickOnLinkToTaskListPage(taskListName);
		AddTaskPage addTask = taskListPage.clickOnAddTaskButton();

		Reporter.log("<p>Adding the first task</p>");
		final String whoShouldDoTheTask = "fake06 fake06 (me)";
		final String firstTaskName = "nonsense task"
				+ Long.toString(System.currentTimeMillis());
		this.submitTask(addTask, firstTaskName, whoShouldDoTheTask);

		Reporter.log("<p>Adding the second task</p>");
		final String secondTaskName = "nonsense task"
				+ Long.toString(System.currentTimeMillis());
		this.submitTask(addTask, secondTaskName, whoShouldDoTheTask);

		Reporter.log("<p>Verifying that the task list and the tasks exist</p>");
		tasks = taskListPage.clickOnMilestonesItem().clickOnTasksItem();
		this.sleep(2000);
		taskListPage = tasks.clickOnLinkToTaskListPage(taskListName);
		Assert.assertTrue(taskListPage.isTaskExists(firstTaskName));
		Assert.assertTrue(taskListPage.isTaskExists(secondTaskName));

		Reporter.log("<p>Deleting the task list</p>");
		TaskListOptions listOptions = taskListPage.openListOptions();
		tasks = listOptions.clickToDeleteTaskList();
		
		Reporter.log("<p>Logging out</p>");
		this.sleep(5000);
		login = tasks.logout();
	}

	private void submitTask(AddTaskPage addTask, final String taskName,
			final String whoShouldDoTheTask) {
		addTask.sendkeysTaskName(taskName);
		addTask.selectWhoShouldDoThis(whoShouldDoTheTask);
		addTask.submitTask();		
		this.sleep(1000);
	}

	private void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
