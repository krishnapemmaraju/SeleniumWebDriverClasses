package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExeCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.spicejet.com");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement dateEle = chromeDriver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		String dateVal = "30-12-2019";
		selectDateByJS(dateEle, chromeDriver, dateVal);

	}
	
	public static void selectDateByJS(WebElement element , WebDriver driver , String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", element);
	}

}
