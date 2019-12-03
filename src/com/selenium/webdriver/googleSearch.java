package com.selenium.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.google.com");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String title = chromeDriver.getTitle();
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());

		chromeDriver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("testing");
		List<WebElement> list = chromeDriver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("testing time")) {
				list.get(i).click();
				break;
			}
		}

	}

}
