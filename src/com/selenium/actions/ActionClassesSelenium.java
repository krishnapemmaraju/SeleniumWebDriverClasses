package com.selenium.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassesSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\KrishnaData\\Selenium\\chromedriver_win3277V\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.spicejet.com/");

		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();

		chromeDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Implicit wait is applicable for the elements
		
		// Mouse Movement

		Actions action = new Actions(chromeDriver);
		action.moveToElement(chromeDriver.findElement(By.linkText("ADD-ONS"))).build().perform();
		chromeDriver.findElement(By.linkText("Hot Meals")).click();

		// Double Mouse Hover
		action.moveToElement(chromeDriver.findElement(By.id("Login"))).build().perform();
		action.moveToElement(chromeDriver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		chromeDriver.findElement(By.linkText("Sign up")).click();
        chromeDriver.close();
        
        // Drag and Drop

		chromeDriver.get("https://jqueryui.com/droppable/");
		chromeDriver.switchTo().frame(0);

		Actions actionDrag = new Actions(chromeDriver);
		actionDrag.clickAndHold(chromeDriver.findElement(By.xpath("//*[@id='draggable']/p")))
				.moveToElement(chromeDriver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();
       String test = chromeDriver.findElement(By.xpath("//*[@id='droppable']/p")).getText();
       System.out.println(test);
       if ( test.equals("Dropped!")) {
    	   System.out.println("Test is pass");
       }else {
    	   System.out.println("Test is fail");
       }
	 
	}

}
