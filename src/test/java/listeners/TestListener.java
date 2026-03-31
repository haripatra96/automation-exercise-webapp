package listeners;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.DriverManager;
import reports.ExtentReportManager;
import utils.ScreenshotUtility;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String path =null;
		System.out.println("Test is failed: "+result.getName());
		ExtentReportManager.getTest().fail(result.getThrowable());
		try {
			 path =ScreenshotUtility.captureScreenshot(DriverManager.getdriver(), result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportManager.getTest().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed: "+result.getName());
		ExtentReportManager.getTest().log(Status.PASS, "test is passed");
	}

	//Hello
}
