package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003  extends BaseClass{
	
	@Test
	public void addNewCustomer() throws IOException {
		
		TC_LoginTest_001 loginTest = new TC_LoginTest_001();
		loginTest.loginTest();
		/*
		 * LoginPage loginPage = new LoginPage(driver); loginPage.setUserName(userName);
		 * loginPage.setPassword(password); loginPage.clickSubmit();
		 */
	
		
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.clickAddNewCustomer();
		addCustomerPage.customerName("neema");
		addCustomerPage.customerGender("male");
		addCustomerPage.dateOfBirth("06", "09", "1987");
		addCustomerPage.customerAddress("india");
		addCustomerPage.customerCity("banglore");
		addCustomerPage.customerState("karnataka");
		addCustomerPage.pincode("560098");
		addCustomerPage.custPhone("99898989");
		addCustomerPage.custEmailid(randomString()+"@gamil.com");
		addCustomerPage.custPassword("kkkkk");
		addCustomerPage.submitBtn();
		
		boolean result= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true) {
			Assert.assertTrue(true);
			logger.info("Add New CustomerTest Passed");
		}else {
			logger.info("Add New CustomerTest failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}

	
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 