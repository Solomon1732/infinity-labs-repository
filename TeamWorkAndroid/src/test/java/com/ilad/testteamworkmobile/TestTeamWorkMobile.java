package com.ilad.testteamworkmobile;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.teamwork.ActiveTaskListsPage;
import com.ilad.teamwork.AllActivityPage;
import com.ilad.teamwork.AllProjectsPage;
import com.ilad.teamwork.LoginPage;
import com.ilad.teamwork.ProjectHomePage;
import com.ilad.teamwork.TabsMenu;

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
		LoginPage login = new LoginPage(driver);
		AllActivityPage allActivity = login.submitLogin(email, password);
		
		TabsMenu menu = (TabsMenu) allActivity.navigateUp();
		AllProjectsPage projects = menu.goToProjects();
		ProjectHomePage webDriverProject = projects.selectProject("WebDriver Training");
		ActiveTaskListsPage activeTaskLists = webDriverProject.goToTasks();
		
		final String taskListName = "CanOfWorms"
				+ Long.toString(System.currentTimeMillis());
		AddTaskList newTaskList = activeTaskLists.addTaskList(taskListName);
		
		newTaskList.addTitle(taskListName);
		
		final String taskListDescription = "I hate Smirfs!!";
		newTaskList.addDescription(taskListDescription);
		
		activeTaskLists = newTaskList.saveList();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
