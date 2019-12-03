package com.selenium.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.UserDataHandler;

public class TakeScreenShotsSelenium {
	
	public static void main(String ar[]) throws IOException {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
	WebDriver chromeDriver = new ChromeDriver();
	chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	chromeDriver.manage().deleteAllCookies();
	chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	chromeDriver.get("https://www.next.co.uk/");
	
	File src = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(src, new File("C:/Users/kpemmaraju/eclipse-workspace/SeleniumJavaProject/src/TestFile.png"));
	
	}
}
