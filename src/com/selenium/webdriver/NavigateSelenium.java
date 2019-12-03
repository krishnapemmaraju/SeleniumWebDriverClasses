package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateSelenium {
	
	public static void main(String ar[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		chromeDriver.get("https://www.next.co.uk/");
		chromeDriver.navigate().to("https://www.amazon.com/");
		chromeDriver.navigate().back();
		Thread.sleep(3000);
		chromeDriver.navigate().forward();
		Thread.sleep(3000);
		chromeDriver.navigate().back();
		chromeDriver.navigate().refresh();
	
	}

}
