package com.ilad.teamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends AbstractTeamWork {


	public LoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void enterEmail(String email) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='Email Address or API Key']");
		this.type(element, email, false);
	}
	
	public void enterPassword(String password) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView"
				+ "[@text='Password']");
		this.type(element, password, false);
	}
	
	public void tapLogin() {
		driver.findElementByClassName("android.widget.Button").click();
	}
	
	public AllActivityPage submitLogin(String email, String password) {
		this.enterEmail(email);
		this.enterPassword(password);
		this.tapLogin();
		return new AllActivityPage(driver);
	}
}
