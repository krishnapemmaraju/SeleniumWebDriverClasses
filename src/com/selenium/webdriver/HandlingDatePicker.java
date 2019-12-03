package com.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDatePicker {
	
	public static void main (String ar[]) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://www.globalsqa.com/demo-site/datepicker/");
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String date_data = "09/11/2019";
		String[] date_split = date_data.split("/");
		String day = date_split[0];
		String month = date_split[1];
		String year = date_split[2];
		
//		//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[1]
		
		String beforeXpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		int totalWeek = 7;
		chromeDriver.findElement(By.id("datepicker")).click();
		
		for ( int rownum = 1;rownum<7;rownum++) {
			for ( int colnum=1;colnum<=7;colnum++) {
				String pathX= beforeXpath + rownum + afterXpath+colnum+"]";
				String txt = chromeDriver.findElement(By.xpath(beforeXpath + rownum + afterXpath+colnum+"]")).getText();
			}
		}
		
		
	}

}
