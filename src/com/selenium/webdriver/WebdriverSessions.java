package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebdriverSessions {

	public static void main(String ar[]) {

		// //launch the FF browser
		// // Gecko driver - for Fire Fox
		// // Gecko driver is a class , we need to create a Object of GeckoDriver

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\KrishnaData\\Selenium\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		// WebDriver FFdriver = new FirefoxDriver();
		// FFdriver.get("https://d3h3f06uocdxq5.cloudfront.net/auth/login");

		// //launch Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.phptravels.org");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String title = chromeDriver.getTitle();
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		
		// Locators
		chromeDriver.findElement(By.linkText("Register")).click();
		chromeDriver.findElement(By.id("inputFirstName")).sendKeys("KK");
		chromeDriver.findElement(By.id("inputLastName")).sendKeys("Pemmaraju");
		chromeDriver.findElement(By.xpath("//*[@id='inputEmail']")).sendKeys("test1985@gmail.com");
		chromeDriver.findElement(By.name("phonenumber")).sendKeys("0987677788");
        chromeDriver.findElement(By.cssSelector("#inputCompanyName")).sendKeys("UST Global");
        chromeDriver.findElement(By.id("inputAddress1")).sendKeys("Flat 11 , Hazelwood Court");
        chromeDriver.findElement(By.id("inputAddress2")).sendKeys("Derby Road , Urmston");
        chromeDriver.findElement(By.id("inputCity")).sendKeys("Manchester");
        chromeDriver.findElement(By.id("stateinput")).sendKeys("Lancashire");
        chromeDriver.findElement(By.id("inputPostcode")).sendKeys("M41 0UF");
        
        Select selectCountry = new Select(chromeDriver.findElement(By.id("inputCountry")));
        selectCountry.selectByVisibleText("United Kingdom");
        
        // dropdown
        Select seleDropDown = new Select(chromeDriver.findElement(By.id("customfield1")));
        seleDropDown.selectByVisibleText("Google");
        
        chromeDriver.findElement(By.cssSelector("#customfield2")).sendKeys("098899009");
        chromeDriver.findElement(By.id("inputNewPassword1")).sendKeys("Password1");
        chromeDriver.findElement(By.id("inputNewPassword2")).sendKeys("Password1");
        
        chromeDriver.findElement(By.xpath("//*[@id='frmCheckout']/p/input")).click();
        
		// quit() method is there to quit the browser

		//chromeDriver.close();

		//// //launch Edge Driver
		////
		// System.setProperty("webdriver.edge.driver",
		//// "C:\\KrishnaData\\Selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
		// WebDriver edgeDriver = new EdgeDriver();
		// edgeDriver.get("https://d3h3f06uocdxq5.cloudfront.net/auth/login");

	}

}
