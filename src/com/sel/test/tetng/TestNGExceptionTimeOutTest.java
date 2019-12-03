package com.sel.test.tetng;

import org.testng.annotations.Test;

public class TestNGExceptionTimeOutTest {

	 @Test(timeOut=2000,expectedExceptions=NumberFormatException.class)
	 public static void Test1() {
		 String data = "test";
		 int j=0;
		 int k = Integer.parseInt(data)+j;

		 }
	 }
	
