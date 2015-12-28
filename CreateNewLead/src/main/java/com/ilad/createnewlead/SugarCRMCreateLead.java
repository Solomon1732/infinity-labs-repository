package com.ilad.createnewlead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * A page handler for the lead creation page in a SugarCRM account
 * @author Shlomi Reuveni
 * @since Dec 22 2015
 */
public class SugarCRMCreateLead extends AbstractSugarCRMPage {
	/**
	 * A constructor
	 * @param driver the WebDriver used to manipulate the lead creation page
	 */
	public SugarCRMCreateLead(WebDriver driver) {
		super(driver);
		Assert.assertTrue(actionbot.isPage(By.id("salutation")));
	}

	/**
	 * Checks if the lead is created
	 * @return true if the lead is created; otherwise false
	 */
	public boolean isCreated() {
		return actionbot.isElementPresent(By.id("edit_button"));
	}

	/**
	 * Checks if the page is the lead creation page
	 * @return true if the page is the creation page; otherwise false
	 */
	public boolean isCreationPage() {
		return actionbot.isPage(By.id("salutation"));
	}

	/**
	 * Save the lead created. Note that a successful save is not guaranteed
	 */
	public void saveLead() {
		actionbot.click(By.id("SAVE_HEADER"));
	}

	/**
	 * Fills in the fields of the lead
	 * @param firstName the first name of the lead
	 * @param lastName the last name of the lead
	 * @param salutation the salutation of the lead
	 * @param checkBox the check box for copying the address from the left
	 */
	public void fillFields(String firstName, String lastName, String salutation,
			boolean checkBox) {
		actionbot.selectByValue(By.id("salutation"), salutation);
		actionbot.type(By.id("first_name"), firstName);
		actionbot.type(By.id("last_name"), lastName);
		actionbot.click(By.id("alt_checkbox"));
	}

}
