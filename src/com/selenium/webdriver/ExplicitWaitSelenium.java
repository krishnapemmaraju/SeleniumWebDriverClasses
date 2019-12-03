package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSelenium {
	
	public static void main(String ar[]) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		
		chromeDriver.get("https://www.next.co.uk/");
		
		
		
	}
	public static void clickOn(WebDriver driver , WebElement locator , int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	    locator.click();
	}
	
	public static void select(WebDriver driver , WebElement locator , int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeSelected(locator));
	    locator.click();
	}

}
