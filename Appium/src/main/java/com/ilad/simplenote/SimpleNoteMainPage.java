package com.ilad.simplenote;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SimpleNoteMainPage extends AbstractSimplenotePage {

	public SimpleNoteMainPage(final AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public NoteEditingPage CompriseNewNote() {
		driver.findElementByClassName("android.widget.ImageView").click();
		return new NoteEditingPage(driver);
	}

	public NoteEditingPage editNote(String noteTitle) {
		driver.findElementByXPath("//android.widget.TextView[@text='" + noteTitle + "']").click();

		return new NoteEditingPage(driver);
	}


}
