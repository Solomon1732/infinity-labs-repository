package com.ilad.testsimplenotes;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.simplenote.NoteEditingPage;
import com.ilad.simplenote.SimpleNoteMainPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSimpleNotes {

	private AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("Simplenote.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.automattic.simplenote");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".NotesActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testAddNewNote(){
		final String tags = "Simple note ";
		final String noteContent = "Hello world\nThis is an example";
		Reporter.log("Given the application Simplenote is opened");
		Reporter.log("When the user creates a new note");
		SimpleNoteMainPage mainPage = new SimpleNoteMainPage(driver);
		NoteEditingPage noteEditing = mainPage.CompriseNewNote();
		
		Reporter.log("And the user add some content to the note");
		noteEditing.EnterNewTags(tags);
		noteEditing.EnterNewNote(noteContent);

		Reporter.log("And the note is saved");
		mainPage = noteEditing.navigateToMainPage();
		
		Reporter.log("When the same note is selected");
		noteEditing = mainPage.editNote("Hello world");
	
		Reporter.log("Then it holds the same content");
		Assert.assertEquals(noteEditing.getTagText(), tags);
		Assert.assertEquals(noteEditing.getContentText(), noteContent);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
