package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {
	
	public static void main(String ar[]) {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
	WebDriver chromeDriver = new ChromeDriver();
	chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	chromeDriver.manage().deleteAllCookies();
	chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	chromeDriver.get("https://html.com/input-type-file/");
	chromeDriver.findElement(By.id("fileupload"));

	}
	}
