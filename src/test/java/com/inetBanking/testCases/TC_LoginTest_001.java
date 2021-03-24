package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL is opened");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Enter username");
		loginPage.setPassword(password);
		logger.info("Enter password");
		
		loginPage.clickSubmit();
		//BaseClass.captureScreen(driver, "loginTest");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passes");
		}else{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		

	}

}
