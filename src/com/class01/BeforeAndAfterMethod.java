package com.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethod {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	
	@Test
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test 
	public void testMethod2() {
		System.out.println("testMethod2");
	}
	
	
	@AfterMethod public void afterMethod() {
		System.out.println("afterMethod");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
