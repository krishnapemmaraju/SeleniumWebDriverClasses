package com.selenium.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ConfigPropReadingFile {

	public static void main(String ar[]) throws IOException {

		WebDriver driver = null;
		ConfigPropReadingFile cpr = new ConfigPropReadingFile();

		Properties props = new Properties();
		String path = System.getProperty("user.dir");
		String filePath = path + "/src/com/selenium/webdriver/config.properties";
		FileInputStream fis = new FileInputStream(new File(filePath));
		props.load(fis);

		if (props.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", props.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		}

		else if (props.getProperty("browser").contains("FireFox")) {
			System.setProperty("webdriver.gecko.driver", props.getProperty("FFDriverPath"));
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(props.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// registering the Customer
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath(props.getProperty("emailAddress_xpath"))).sendKeys(props.getProperty("emailAddress"));
		driver.findElement(By.xpath(props.getProperty("createAccButton_xpath"))).click();
		driver.findElement(By.xpath(props.getProperty("genderID_xpath"))).click();
		driver.findElement(By.xpath(props.getProperty("custFirstName_xpath"))).sendKeys(props.getProperty("custFirstName"));
		driver.findElement(By.xpath(props.getProperty("custLastName_xpath"))).sendKeys(props.getProperty("custLastName"));
		driver.findElement(By.xpath(props.getProperty("custPassword_xpath"))).sendKeys(props.getProperty("custPassword"));

		cpr.selectDropDown(driver, "days" , "16");
		cpr.selectDropDown(driver, "months" , "3");
		cpr.selectDropDown(driver, "years" , "1985");

	}
	
	public void selectDropDown(WebDriver driver ,String loc , String text) {
		Select seldrpdwn = new Select(driver.findElement(By.id(loc)));
		seldrpdwn.selectByValue(text);
	}
}
