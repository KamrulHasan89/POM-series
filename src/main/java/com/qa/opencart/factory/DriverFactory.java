package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		System.out.println("browser name is : " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
		    driver = new SafariDriver();
		}
		else {
			System.out.println("please pass the right browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    driver.get(prop.getProperty("url"));
		return driver;
	
		}
	
	 public Properties initProp() {
		  prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/conconfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	 }

}
