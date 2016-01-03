package com.ilad.testteamworkmobile;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.teamwork.ActiveTaskListsPage;
import com.ilad.teamwork.AddTaskList;
import com.ilad.teamwork.AllActivityPage;
import com.ilad.teamwork.AllProjectsPage;
import com.ilad.teamwork.ConfirmTaskDeletion;
import com.ilad.teamwork.LoginPage;
import com.ilad.teamwork.NewTask;
import com.ilad.teamwork.ProjectHomePage;
import com.ilad.teamwork.TabsMenu;
import com.ilad.teamwork.TaskListOptions;
import com.ilad.teamwork.TaskList;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestTeamWorkMobile {
	private final String email = "fake06@fake.com";
	private final String password = "fake";
	private AndroidDriver<WebElement> driver;
	String taskListName = Long.toString(System.currentTimeMillis());

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("teamwork.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "google "
				+ "Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,
				"net.teamworkpm.phone");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,
				".ProjectsActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/"
				+ "wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAddNewTaskList() {
		Reporter.log("Logging in TeamWork app");
		LoginPage login = new LoginPage(driver);
		AllActivityPage allActivity = login.submitLogin(email, password);

		Reporter.log("Navigating to task list");
		TabsMenu menu = allActivity.navigateUp();
		AllProjectsPage projects = menu.goToProjects();
		ProjectHomePage webDriverProject = projects.selectProject("WebDriver Training");
		ActiveTaskListsPage activeTaskLists = webDriverProject.goToTasks();

		Reporter.log("Creating a new task list");
		final String taskListName = "CanOfWorms"
				+ Long.toString(System.currentTimeMillis());
		AddTaskList newTaskList = activeTaskLists.addTaskList(taskListName);

		Reporter.log("Adding a title to the task list");
		newTaskList.addTitle(taskListName);

		Reporter.log("Adding a description to the task list");
		final String taskListDescription = "I hate Smurfs!!";
		newTaskList.addDescription(taskListDescription);

		Reporter.log("Saving the task list");
		activeTaskLists = newTaskList.saveList();

		Reporter.log("Selecting the newly created list");
		TaskList taskList = activeTaskLists.selectTaskList(taskListName);

		Reporter.log("Adding a first task");
		TaskListOptions listOptions = taskList.listOptions();
		NewTask newTask = listOptions.addTask();

		Reporter.log("Adding a title to the task");
		final String firstTaskTitle = "Just a task"
				+ Long.toString(System.currentTimeMillis());
		newTask.addTitle(firstTaskTitle);
		
		Reporter.log("Adding a description to the task");
		final String firstTaskDescription = "Simple description for a simple task";
		newTask.addDescription(firstTaskDescription);
		
		Reporter.log("Saving the first task");
		taskList = newTask.save();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Reporter.log("Adding a second task");
		listOptions = taskList.listOptions();
		newTask = listOptions.addTask();

		Reporter.log("Adding a title to the task");
		final String secondTaskTitle = "Just another task"
				+ Long.toString(System.currentTimeMillis());
		newTask.addTitle(secondTaskTitle);
		
		Reporter.log("Adding a description to the task");
		final String secondTaskDescription = firstTaskDescription;
		newTask.addDescription(secondTaskDescription);
		
		Reporter.log("Saving the second task");
		taskList = newTask.save();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Reporter.log("Asserting that both tasks exist");
		Assert.assertTrue(taskList.isTaskExist(firstTaskTitle));
		Assert.assertTrue(taskList.isTaskExist(secondTaskTitle));
		
		Reporter.log("Deleting task list");
		listOptions = taskList.listOptions();
		ConfirmTaskDeletion confirmDelete = listOptions.deleteTaskList();
		activeTaskLists = confirmDelete.delete();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
