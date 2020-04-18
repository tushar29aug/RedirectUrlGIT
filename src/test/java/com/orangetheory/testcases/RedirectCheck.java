package com.orangetheory.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.orangetheory.base.BasePage;
import com.orangetheory.utilities.TestUtils;

public class RedirectCheck extends BasePage {
	
	@BeforeTest
	public void setUp() throws IOException{
		initialize();
	}
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="getData")
	public void checkRedirect(String current, String redirect) throws InterruptedException{
		driver.get(current);
		Thread.sleep(2000);
		String redirectUrl = driver.getCurrentUrl();
		System.out.println(redirectUrl);
		Assert.assertEquals(redirectUrl, redirect);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}