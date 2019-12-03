package com.selenium.webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingBrokenLinkSessions {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		chromeDriver.get("https://d3h3f06uocdxq5.cloudfront.net/auth/login");
		chromeDriver.findElement(By.id("emailAddress")).sendKeys("testautomation2@searchflow.co.uk");
		chromeDriver.findElement(By.id("password")).sendKeys("Password1");
		chromeDriver.findElement(By.id("login-button")).click();

		List<WebElement> list = chromeDriver.findElements(By.tagName("a"));
		System.out.println("The number of a tags are " + list.size());

		list.addAll(chromeDriver.findElements(By.tagName("img")));
		System.out.println("The number of a and img tags  are " + list.size());

		List<WebElement> listActive = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAttribute("href"));
			if (list.get(i).getAttribute("href") != null && !((list.get(i).getAttribute("href").contains("Javascript")))
					&& !((list.get(i).getAttribute("href").contains("tel")))
					&& !(list.get(i).getAttribute("href").contains("mailto"))) {
				listActive.add(list.get(i));
			}
		}
		System.out.println("The Active Links are " + listActive.size());

		for (int j = 0; j < listActive.size(); j++) {
			HttpURLConnection connect = (HttpURLConnection) new URL(listActive.get(j).getAttribute("href"))
					.openConnection();
			connect.connect();
			connect.getResponseMessage();
			connect.disconnect();
			System.out.println("The Message for the Link" + connect.getResponseMessage());
		}

		/*chromeDriver.findElement(By.linkText("Settings")).click();
		chromeDriver.findElement(By.id("logout")).click();*/
		chromeDriver.quit();
	}

}
