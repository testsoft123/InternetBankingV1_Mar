package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver localDriver;
	public AddCustomerPage(WebDriver remoteDriver) {
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtDob;
	

	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtTxt;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtPhone;
	

	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSub;
	
	@FindBy(how=How.NAME,using="res")
	@CacheLookup
	WebElement btnReset;
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void customerName(String customerName) {
		txtCustomerName.sendKeys(customerName);
	}
	
	public void customerGender(String gender) {
		rdGender.click();		
	}
	public void dateOfBirth(String mm, String dd, String yyyy) {
		
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}
	public void customerAddress(String address) {
	txtAddress.sendKeys(address);
		
	}
	public void customerCity(String city) {
		txtCity.sendKeys(city);
	}
	public void customerState(String state) {
		txtState.sendKeys(state);
	}
	public void pincode(String pincode) {
		txtPin.sendKeys(pincode);
	}
	public void custPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	public void custEmailid(String emaild) {
		txtEmailid.sendKeys(emaild);
	}
	public void custPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void submitBtn() {
		btnSub.click();
	}
	public void resetBtn() {
		btnReset.click();
	}
	
	
	
	
	
	
}
