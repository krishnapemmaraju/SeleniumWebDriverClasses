package com.selenium.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropBoxHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
	
		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		chromeDriver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		chromeDriver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List <WebElement> ls = chromeDriver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		 
		System.out.println(ls.size());
		for ( int i=0;i<ls.size();i++) {
			if ( ls.get(i).isSelected()) {
				System.out.println(ls.get(i).getText());
				ls.get(i).click();
	}
		}
		
//		for ( int i=0;i<ls.size();i++) {			
//				ls.get(i).click();
//		}
//	
	}

}
