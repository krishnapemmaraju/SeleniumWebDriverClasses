package com.sel.test.tetng;

import org.testng.annotations.Test;

public class TestNGInvocationCount {
	
	@Test(invocationCount=4)
	public void sum() {
		int a=10;
		int b=20;
		int c=30;
		System.out.println(a+b+c);
	}

}
