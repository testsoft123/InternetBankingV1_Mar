package com.inetBanking.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	// common variable
	public String baseURL = ReadConfig.readPropertyFileData("baseURL");
	public String userName = ReadConfig.readPropertyFileData("userName");
	public String password = ReadConfig.readPropertyFileData("password");
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass

	public void setUp(String browserName) {

		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadConfig.readPropertyFileData("chromePath"));
			driver = new ChromeDriver();
		} else if (browserName.equals("firFox")) {
			System.setProperty("webdriver.gecko.driver", ReadConfig.readPropertyFileData("fireFoxPath"));
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/*********************** Data and Time ***********************/
	public static String dateTime() {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH.mm.ss");
		LocalDateTime currentDate = LocalDateTime.now();
		String currentTime = dateTimeFormatter.format(currentDate);
		return currentTime;

	}

	/********* Take ScreenShot *****************/
	public static void captureScreen(WebDriver driver, String sheet) throws IOException {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/ScreenShots/";
		FileUtils.copyFile(scr, new File(path + sheet + "_" + dateTime() + ".png"));
		logger.info("screen shot taken");

	}

	/**************** Random string Method *********************/
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	/**************** Random INETGER Method *********************/
	public String randomNumber() {
		String generatedString = RandomStringUtils.randomNumeric(8);
		return generatedString;
	}
	/***********user defined method  created to check alert is present or not ************/
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
	   }
   }
}
