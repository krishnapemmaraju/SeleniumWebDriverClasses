package com.sel.test.tetng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("This is Set up for Chrome");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("Launch Chrome Browser");
	}

	@BeforeMethod
	public void EnterUrl() {
		System.out.println("Enter the Url");
	}
	
	@BeforeTest
	public void login() {
		System.out.println("Enter User Login");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Enter Some Search");
	}
	
	@Test
	public void getTtitle() {
		System.out.println("Get the google Title");
	}

	@AfterMethod
	public void logout() {
		System.out.println("log out");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("Delete all cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}

   @AfterSuite
   public void endTest() {
	   System.out.println("Generate Test Report");
   }
}

