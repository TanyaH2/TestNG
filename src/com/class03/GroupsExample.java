package com.class03;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/*
 * setUpSecurity()
accessAdminPage()
accessHomePage()
tearDownSecurity()

setUpUI()
openConfirmationDialog()
openFileDialog()
tearDownUI()

setUpDatabase()
testDelete()
testInsert()
testUpdate()
tearDownDatabase()
 */
public class GroupsExample {

	@BeforeGroups({ "Smoke", "Regression" })
	public void beforeGroups() {
		System.out.println("Before Groups");
	}

	@Test(groups = "Smoke")
	public void testOne() {
		System.out.println("1Test one 2S");
	}

	@Test(groups = "Regression")
	public void testTwo() {
		System.out.println("2Test two 2R");
	}

	@Test(groups = "Smoke")
	public void testThree() {
		System.out.println("3Test three 2S");
	}

	@Test(groups = "Regression")
	public void testFour() {
		System.out.println("4Test four 2R");
	}

	@AfterGroups({ "Smoke", "Regression" })
	public void afterGroups() {
		System.out.println("After Groups");
	}
}
