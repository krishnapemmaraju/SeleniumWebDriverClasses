package com.sel.test.tetng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPracGoogleTest {
	
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
	
	@Test(priority = 2,groups="Title")
	public void googleTitleTest() {
		System.out.println(driver.getTitle());
	}
	
	
	@Test(priority = 1,groups = "logo")
	public void googleLogoTest() {
		System.out.println(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed());
	}
	
	@Test(priority = 3,groups="sample")
	public void testcase1() {
		System.out.println("Testcase1");
	}
	
	@Test(priority = 4,groups="sample")
	public void testcase2() {
		System.out.println("Testcase2");
	}
	
	@Test(priority = 5,groups="sample")
	public void testcase3() {
		System.out.println("Testcase3");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
