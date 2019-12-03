package com.selenium.webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksSession {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		chromeDriver.get("http://newtours.demoaut.com/");

		chromeDriver.findElement(By.xpath("//input[@name='userName']")).sendKeys("krishnap");
		chromeDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("krishnap");
		chromeDriver.findElement(By.xpath("//input[@name='login']")).click();

		// get the list of all the links and images

		List<WebElement> list = chromeDriver.findElements(By.tagName("a"));
		list.addAll(chromeDriver.findElements(By.tagName("img")));

		List<WebElement> listActive = new ArrayList<WebElement>();
		Iterator itr = list.iterator();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAttribute("href"));
			if (list.get(i).getAttribute("href") != null && (!(list.get(i).getAttribute("href").contains("javascript")))) {
				listActive.add(list.get(i));
			}
		}
		System.out.println(list.size());
		System.out.println(listActive.size());

		for (int j = 0; j < listActive.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(listActive.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			connection.getResponseMessage();
			connection.disconnect();
			System.out.println(listActive.get(j).getAttribute("href") + "---->" +  connection.getResponseMessage());
		}
	}

}
