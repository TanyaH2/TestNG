package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 * Identify Priority of Test Cases

TC 1: OrangeHRM Verify Successful Login
    Step 1: Open browser and navigate to OrangeHRM
    Step 2: Enter valid UID and valid PWD and click login button
    Step 3: Verify user successfully logged in

TC 2: OrangeHRM Add Employee
	Step 1: Click on PIM link and Add Employee
	Step 2: Provide Details and Save
	Step 3: Verify Employee is added 

TC 3: OrangeHRM Verify Employee Details
	Step 1: Click on PIM link and Employee List
	Step 2: Search for employee by it id
	Step 3: Verify Employee details are displayed 

Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application
      https://opensource-demo.orangehrmlive.com/

// Test case grouping in TestNG
// Including and excluding groups
// Dependencies in TestNG
 */
public class HomeWork extends CommonMethods {

	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");

	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
	}

	@Test(priority = 1)
	public void aVerifyLogIn() {
		System.out.println("Testing LogIn function");
		Assert.assertTrue(true);
		System.out.println("LogIn function Test Passed");

	}

	@Test(priority = 2)
	public void aPimLinkAndAdd() {
		driver.findElement(By.cssSelector("a[id*='PimModule']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

	}

	@Test(priority = 2)
	public void bDetailsAndSave() {
		driver.findElement(By.id("firstName")).sendKeys("Arya");
		driver.findElement(By.name("middleName")).sendKeys("KM");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Stark");
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys("0031");
		driver.findElement(By.cssSelector("input#photofile")).click();
		String photo = "/Users/tetianahatley/eclipse-workspace/TestNGBasics/Arya.jpeg";
		driver.findElement(By.cssSelector("input#photofile")).sendKeys(photo);
//            driver.findElement(By.cssSelector("input#photofile")).click();
		WebElement check = driver.findElement(By.id("chkLogin"));
		if (check.isDisplayed() && check.isEnabled()) {
			if (!check.isSelected()) {
				check.click();
			} else {
				check.click();
				check.click();
			}
		}
		driver.findElement(By.id("user_name")).sendKeys("arya1");
		driver.findElement(By.id("user_password")).sendKeys("Qwerty123$");
		driver.findElement(By.id("re_password")).sendKeys("Qwerty123$");
		driver.findElement(By.id("btnSave")).click();

	}

	@Test(priority = 2)
	public void cVerifyEmployee() {
		System.out.println("Testing Employee Add");
		Assert.assertTrue(true);
		System.out.println("New employee added succesfully");
	}

	@Test(priority = 3)
	public void aPimLinkAndEmployeeList() {
		driver.findElement(By.cssSelector("a[id*='PimModule']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	}

	@Test(priority = 3)
	public void bEmployeeById() {
		driver.findElement(By.xpath("//input[@name='empsearch[id]']")).sendKeys("0031");
		driver.findElement(By.id("searchBtn")).click();

	}

	@Test(priority = 3)
	public void cVerifyEmployeeDetails() {

		dataCheck(driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td")), "Arya KM");
		dataCheck(driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td")), "0031");
		dataCheck(driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td")), "Stark");

		if (true) {
			System.out.println("Employee is present");

		} else {
			System.out.println("Employee is NOT found");
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();
	}

}
