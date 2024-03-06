package com.RMGOnlineShoppingApp.genericutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
	//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		 test = report.createTest(MethodName);
		 Reporter.log(MethodName+"===> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"====> Passed");
		Reporter.log(MethodName+"====>Testscript exccuted successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
		String name=result.getMethod().getMethodName();
		WebDriverUtils wb=new WebDriverUtils();
		String src = wb.getScreenShot(BaseClass.driver, name);
		
		test.log(Status.FAIL,name+"===> TestScript failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(name+"====>Failed");
		test.addScreenCaptureFromPath(src);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"====>Skipped");
	}


	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("RMG_Shopping_App");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("RMG");
		
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 
		 report.setSystemInfo("Base Platform", "Windows 10");
		 report.setSystemInfo("Base Browser", "Chrome");
		 report.setSystemInfo("Base Url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		 report.setSystemInfo("Reporter Name", "Shivkumar CY");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
