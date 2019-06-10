package com.class03;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test()
	public void one() {
		System.out.println("One Test");
	}

	@Test(dependsOnMethods = "one")
	public void two() {
		System.out.println("Two Test");

	}

	@Test(dependsOnMethods = "two")
	public void three() {
		System.out.println("Three Test");

	}

}
