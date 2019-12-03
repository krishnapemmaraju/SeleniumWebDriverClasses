package com.selenium.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class seleniumHeadLessBrowser {
	
	//HTMLUnitDriver
	
	public static void main(String ar[]) throws IOException {
		
		// HTMLUnitDriver is not available in Selenium 3.x version
		//we need to download HTMLUnitDriver jar file
		// advantages
		// Testing is happening behind the scene - no browser
		// It is very fast - execution is very fast - Improve performance
		//all the user actions like - mouse movement or double click or drag and drop - cant not do with HTMLUnitDriver
		//HTMLUnitDriver is also called - GhostDriver or Headlessbrowser
		   //HTMLUnitDriver - with Java
		   //PhantomJS - Java script 
		   
		
		WebDriver driver = new HtmlUnitDriver();

		Properties props = new Properties();
		String path = System.getProperty("user.dir");
		String filePath = path + "/src/com/selenium/webdriver/config.properties";
		FileInputStream fis = new FileInputStream(new File(filePath));
		props.load(fis);

		if (props.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", props.getProperty("chromeDriverPath"));
		//	driver = new ChromeDriver();
		}

		else if (props.getProperty("browser").contains("FireFox")) {
			System.setProperty("webdriver.gecko.driver", props.getProperty("FFDriverPath"));
		//	driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(props.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		System.out.println("Before Sign In : Title is :" + driver.getTitle());
		
		driver.findElement(By.linkText("Sign in")).click();
		
		System.out.println("After Sign In : Title is :" +driver.getTitle());

	}

}
