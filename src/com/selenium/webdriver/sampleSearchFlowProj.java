package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sampleSearchFlowProj {
	
	public static void main(String ar[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chrdriver = new ChromeDriver();
		chrdriver.get("https://d3h3f06uocdxq5.cloudfront.net");
		chrdriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chrdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chrdriver.manage().deleteAllCookies();
       
		chrdriver.findElement(By.cssSelector("#emailAddress")).sendKeys("Daniel.preston@searchflow.co.uk");
		chrdriver.findElement(By.id("password")).sendKeys("Password1");
		chrdriver.findElement(By.cssSelector("#login-button")).click();
		
		chrdriver.navigate().refresh();

		
		WebDriverWait waitdriver = new WebDriverWait(chrdriver, 50);
		waitdriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle']")));
		
		chrdriver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	}

}
