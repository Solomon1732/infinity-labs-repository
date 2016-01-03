package com.ilad.teamwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractListTypes extends AbstractLoggedIn {

	public AbstractListTypes(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	@Override
	public TabsMenu navigateUp() {
		WebElement element = driver.findElementByAccessibilityId("Navigate up");
		driver.tap(1, element, 100);
		return new TabsMenu(driver);
	}
	
	public ListFilter listFilterMenu() {
		/*WebElement element = */driver.findElementByAccessibilityId("Filter").click();
		//driver.tap(1, element, 100);
		
		return new ListFilter(driver);
	}

	protected WebElement scrollDownToElement(String elementxPath,
			long initialSleepingTime) {

		Dimension pageSize = driver.manage().window().getSize();
		int width = pageSize.width / 2;
		int startingHeight = pageSize.height * 9 / 10;
		int endingHeight = pageSize.height / 10;

		try {
			Thread.sleep(initialSleepingTime);
		} catch (InterruptedException e) {
		}
		
		this.implicitwait(0, TimeUnit.SECONDS);

		while(driver.findElementsByXPath(elementxPath).isEmpty()) {
			driver.swipe(width, startingHeight, width, endingHeight, 1500);
		}

		this.implicitwait(30, TimeUnit.SECONDS);

		return driver.findElementByXPath(elementxPath);
	}

}
