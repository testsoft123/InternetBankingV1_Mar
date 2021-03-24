package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginDDT(String userName, String password) {
        logger.info("login infomation"); 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("user name Entered");
		loginPage.setPassword(password);
		logger.info("user password Entered");
		loginPage.clickSubmit();

		if (isAlertPresent() == true) {
			driver.switchTo().alert();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login faild");
		} else {
			Assert.assertTrue(true);
			loginPage.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Login");
		int colCount = XLUtils.getCellCount(path, "Login", 1);

		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);
			}
		}
		return loginData;
	}

}
