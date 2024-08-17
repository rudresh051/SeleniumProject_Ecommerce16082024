package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\Configuration\\config");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		} else if(browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		Action.implicitWait(driver,10);
		Action.pageLoadTimeOut(driver,30);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
