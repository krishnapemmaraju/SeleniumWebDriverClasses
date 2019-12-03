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

public class elementVisibilty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		
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

		String pathToStoreScreen = System.getProperty("user.dir");
		String pathtoStore = pathToStoreScreen + props.getProperty("path");

		WebElement ele = driver.findElement(By.linkText("Sign in"));
		
		if(driver.findElement(By.linkText("Sign in")).isDisplayed())
		{
            System.out.println("Element is displayed");
		}
		
		if(driver.findElement(By.linkText("Sign in")).isEnabled())
		{
            System.out.println("Element is Enabled");
		}
		
		//isSelected is applicable for - checkbox , dropbown , radio buttons
		
		
		
		
		


	}

}
