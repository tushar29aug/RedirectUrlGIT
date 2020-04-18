package com.orangetheory.listeners;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListners implements ITestListener {
	
	static Date d = new Date();
	static String file = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
	
	private static ExtentReports extent = ExtentManager.createInstance("C:\\Users\\trast2\\workspace\\RedirectUrlOTF\\reports\\"+file);
	public static ThreadLocal<ExtentTest> testReporter = new ThreadLocal<ExtentTest>();
	public WebDriver driver;

	public void onFinish(ITestContext arg0) {
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.RED);
		testReporter.get().fail(m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.YELLOW);
		testReporter.get().skip(m);
		
	}

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName()+" " +result.getMethod().getMethodName());
		testReporter.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.GREEN);
		testReporter.get().pass(m);
		
	}

}
