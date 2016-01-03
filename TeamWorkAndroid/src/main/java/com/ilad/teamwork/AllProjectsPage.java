package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AllProjectsPage extends AbstractLoggedIn {

	public AllProjectsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public ProjectHomePage selectProject(String projectName) {
		driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='" + projectName + "']").click();
		return new ProjectHomePage(driver);
	}

	@Override
	public TabsMenu navigateUp() {
		/*WebElement element = */driver.findElementByAccessibilityId("Navigate up").click();
//		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}
}
