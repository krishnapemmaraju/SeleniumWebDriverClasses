package com.selenium.webdriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chromeDriver.get("https://www.next.co.uk");
		
		//get all the 'a' tag elements
		List<WebElement> linkList = chromeDriver.findElements(By.tagName("input"));
		//size of the Linked List
		System.out.println(linkList.size());
        
		for ( int j=0; j<linkList.size();j++) {
			System.out.println(linkList.get(j).getText());
		}
		
	}

}
