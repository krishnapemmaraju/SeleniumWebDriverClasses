package com.selenium.webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		ChromeOptions Copts = new ChromeOptions();
		Copts.addArguments("window-size=1400,800");
		Copts.addArguments("headless");
		
		WebDriver chromeDriver = new ChromeDriver(Copts);
		
		chromeDriver.manage().window().maximize();

		chromeDriver.manage().deleteAllCookies();
		
		
		chromeDriver.get("https://www.spicejet.com/");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		chromeDriver.findElement(By.xpath("//li[@id='SpecialAssistanceToPLink']//a[contains(text(),'SpiceClub')]")).click();
		System.out.println(chromeDriver.getTitle());
		chromeDriver.navigate().back();
	
	}

}
