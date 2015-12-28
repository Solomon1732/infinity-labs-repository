package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the Overview page
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class OverviewPage extends AbstractTopQPage {
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public OverviewPage(WebDriver driver_) {
		super(driver_);
		Assert.assertTrue(actionbot.isPage(By.xpath("//h2[./text()='Overview']")));
	}
}
