package com.ilad.simplenote;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class NoteEditingPage extends AbstractSimplenotePage {

	public NoteEditingPage(final AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void EnterNewTags(final String tags) {
		WebElement element = driver.findElementByClassName("android.widget."
				+ "MultiAutoCompleteTextView");
		this.type(element, tags);
	}

	public void EnterNewNote(final String noteContent) {
		WebElement element = driver.findElementByClassName("android.widget.EditText");
		this.type(element, noteContent);
	}

	public SimpleNoteMainPage navigateToMainPage() {
		driver.findElementByAccessibilityId("Navigate up").click();
		return new SimpleNoteMainPage(driver);
	}

	public String getTagText() {
		return driver.findElementByClassName("android.widget.MultiAuto"
				+ "CompleteTextView").getText();
	}

	public String getContentText() {
		return driver.findElementByClassName("android.widget.EditText").getText();
	}

}
