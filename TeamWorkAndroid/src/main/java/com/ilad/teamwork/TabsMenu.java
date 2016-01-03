package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TabsMenu extends AbstractTeamWork {

	public TabsMenu(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public AllProjectsPage goToProjects() {
		driver.findElementByXPath("//android.widget.TextView[@text='Projects']").click();
		return new AllProjectsPage(driver);
	}
}
