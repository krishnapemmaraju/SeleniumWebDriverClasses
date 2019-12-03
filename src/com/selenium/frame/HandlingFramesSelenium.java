package com.selenium.frame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFramesSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://automationpractice.com/index.php");
		
		chromeDriver.manage().window().maximize();
		
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		chromeDriver.findElement(By.xpath("//a[@class='btn btn-default']")).click();

	}

}
