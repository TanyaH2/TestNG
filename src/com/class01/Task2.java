package com.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1.	Create three test case with unique @test methods names.
   2.	Execute the test case
   3.	Post a screenshot of your report
 */
public class Task2 {
	@BeforeMethod
	public void beforeOne() {
		System.out.println("beforeMethod1");
	}
	@BeforeMethod
	public void beforeTwo() {
		System.out.println("beforeMethod2");
	}
	
	@Test 
	public void testThird() {
		System.out.println("test3");
	}
	@Test
	public void testFirst() {
		System.out.println("test1");
	}
	
	@Test 
	public void testZSecond() {
		System.out.println("test2");
	}
	
	
	@AfterMethod public void afterMethod() {
		System.out.println("afterMethod");
		System.out.println();
	}
	

	
	
}
