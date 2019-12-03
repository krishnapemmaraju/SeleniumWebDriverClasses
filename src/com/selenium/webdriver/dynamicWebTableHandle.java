package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicWebTableHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.get("http://demo.automationtesting.in/WebTable.html");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// //*[@id="1569093651841-2-uiGrid-0005-cell"]
		
		String beforeXpath = "//*[@id='1569093651841-";
		String afterXpath = "-uiGrid-0005-cell']";
		
		for ( int i=0;i<=10;i++) {
			System.out.println(beforeXpath+i+afterXpath);

			String txtdata = chromeDriver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
		    System.out.println(txtdata);
		}

	}

}
