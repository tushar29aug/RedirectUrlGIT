package com.orangetheory.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName){
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("OTF Redirect Rules");
		htmlReporter.config().setEncoding("utf-8");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Tushar Rastogi");
	    extent.setSystemInfo("Organization", "Publicis Sapient");
	    extent.setSystemInfo("Build no", "1234");
	        
		return extent;
		
	}

}
