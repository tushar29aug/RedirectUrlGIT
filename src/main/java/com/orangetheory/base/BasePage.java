package com.orangetheory.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public void initialize() throws IOException{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\trast2\\workspace\\RedirectUrlOTF\\src\\main\\java\\com\\orangetheory\\config\\config.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
				
		if(browser.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Headless")){
			driver = new HtmlUnitDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
