package com.sel.test.tetng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleTitleTestAssertion {

	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test
	public void googleTitleTest() {
		String testTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		//Validation
		
		Assert.assertEquals(testTitle, "Google123","Title is not matched");
	}
	
	@Test
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed());
		Assert.assertTrue(b);
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
	}
}
