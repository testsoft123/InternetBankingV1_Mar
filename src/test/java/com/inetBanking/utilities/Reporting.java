package com.inetBanking.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;// update the status and lo

	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Extent-Report/" + repName);// specify  location of the report
																														
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent = new ExtentReports();// missed
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "pavan");

		htmlReporter.config().setDocumentTitle("InitBanking Test Report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult iTestResult) {
		logger = extent.createTest(iTestResult.getName());// Create new entry in report
		logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));// send the passed
																									// information

	}

	public void onTestFailure(ITestResult iTestResult) {
		logger = extent.createTest(iTestResult.getName());// Create new entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.RED));// send the passed
																									// information

		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + iTestResult.getName() + ".png";
		File file = new File(screenShotPath);
		if (file.exists()) {
			try {
				logger.fail("ScreenShot	is below:" + logger.addScreenCaptureFromPath(screenShotPath));

			} catch (IOException e) {
				e.printStackTrace();// TODO: handle exception
			}
		}

	}

	public void onTestSkipped(ITestResult iTestResult) {
		logger = extent.createTest(iTestResult.getName());// Create new entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.ORANGE));// send the passed
																										// information

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
