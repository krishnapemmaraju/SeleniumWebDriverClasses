package com.sel.test.tetng;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		int i = 9/9;
	}
	
	
	@Test(dependsOnMethods="loginTest")
	public void HomePage() {
		System.out.println("Home Test");
		int i = 10/0;
	}
	

	@Test(dependsOnMethods="HomePage")
	public void SearchPage() {
		System.out.println("Search Test");
	}
	
}
