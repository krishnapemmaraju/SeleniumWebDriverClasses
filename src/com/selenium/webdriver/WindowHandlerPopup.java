package com.selenium.webdriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerPopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// handling pop ups

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		chromeDriver.get("http://www.popuptest.com/");
		chromeDriver.findElement(By.linkText("Drop down Popup")).click();

		Thread.sleep(2000);
		
		Set<String> winhandle = chromeDriver.getWindowHandles();

		Iterator<String> itr = winhandle.iterator();
		String parentWindow = itr.next();
		System.out.println("Parent window "  + parentWindow);

		String chlildWindow = itr.next();
		System.out.println("Child window " + chlildWindow);


		chromeDriver.switchTo().window(chlildWindow);
		System.out.println("Child window Title" + chromeDriver.getTitle());

		Thread.sleep(2000);
		
		chromeDriver.close();
		
		Thread.sleep(2000);
		
		chromeDriver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title" +chromeDriver.getTitle());


	}

}
