package com.selenium.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScriptExecutorConceptClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		JavaScriptExecutorConceptClass jsc = new JavaScriptExecutorConceptClass();

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

		// Highlighting the web element
		flash(ele, driver);
		// Border an element
		borderEle(ele, driver);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(pathtoStore + "/screenshot1.png"));

		generateAlert(driver, "there is a error");
		
		//handling alerts
		driver.switchTo().alert().accept();
		
		//clickin on Element using JavascriptExecutor
		
		elementClick(ele, driver);
		
		//refresh browser
		refreshBrowser(driver);
		
		//get title of page by js
		
		System.out.println(getTitle(driver));
		
		//get inner Text by js
		
		System.out.println(getInnerText(driver));
		
		//scrolling through js
		
        pageScroll(driver);
	
	}

	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void borderEle(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}
	
	public static void elementClick(WebElement element , WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
	}
	
	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;
	}
	
	public static String getInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innertext =  js.executeScript("return document.documentElement.innerText;").toString();
	    return innertext;
	}
	
	public static void pageScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
