package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// create driver
	WebDriver localDriver;

	// create constructor and initiate

	public LoginPage(WebDriver remoteDriver) {
		// TODO Auto-generated constructor stub

		localDriver = remoteDriver;// initiation

		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnLogOut;

	// Action method

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String password) {

		txtPassword.sendKeys(password);

	}

	public void clickSubmit() {
		btnLogin.click();

	}
	public void clickLogOut() {
		btnLogOut.click();

	}
}
