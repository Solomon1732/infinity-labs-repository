package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ilad.browser.AbstractPageObject;

/**
 * An abstract AbstractTopQPage object
 * @author Shlomi Reuveni
 * @since Dec 27 2015
 */
public class AbstractTopQPage extends AbstractPageObject{
	/**
	 * A constructor
	 * @param driver_ the driver used to manipulate the page
	 */
	public AbstractTopQPage(WebDriver driver_) {
		super(driver_);
	}

	/**
	 * Logging out of the account
	 * @return a LoginPage object
	 */
	public LoginPage logout() {
		actionbot.click(By.xpath("//div[@id='trUserPic']/a/img"));
		actionbot.click(By.xpath("//div[@id='trUserDrop']/"
				+ "descendant::i[@class='icon-off icon-large']"));
		return new LoginPage(m_driver);
	}
	
	/**
	 * Click on the Tasks tab
	 * @return A TaskPage object
	 */
	public TasksPage clickOnTasksItem() {
		actionbot.click(By.xpath("//li[@id='tab_tasks']/a"));
		return new TasksPage(m_driver);
	}
	
	/**
	 * Click on the Milestones tab
	 * @return a MilestonePages object
	 */
	public MilestonesPage clickOnMilestonesItem() {
		actionbot.click(By.xpath("//li[@id='tab_milestones']/a"));
		return new MilestonesPage(m_driver);
	}
}
