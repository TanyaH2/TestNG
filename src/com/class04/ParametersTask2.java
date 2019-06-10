package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

//Identify Priority of Test Cases
//
//https://www.saucedemo.com/
//
//TC 1: Saucedemo Username1(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username standard_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//TC 2: Saucedemo Username2(parameters - username and password)
//Step 1: Open browser and navigate to Saucedemo
//Step 2: Enter username problem_user and enter password secret_sauce and click login button
//Step 3: Verify user successfully logged in
//
//
//Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file with parameters username and password .
public class ParametersTask2 extends CommonMethods{
	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(String chrome,String url) {
		setUpDriver(chrome,url);
	}
	
	
	@Parameters({"userName1","password"})
	@Test
	public void userName1(String user1,String pass) {
		sendText(driver.findElement(By.id("user-name")), user1);
		sendText(driver.findElement(By.id("password")), pass);
		driver.findElement(By.className("btn_action")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='product_label']")).getText(), "Products");
	
	}

	@Parameters({"userName2","password2"})
	@Test
	public void userName2(String user2,String pass2) {
		sendText(driver.findElement(By.id("user-name")), user2);
		sendText(driver.findElement(By.id("password")), pass2);
		driver.findElement(By.className("btn_action")).click();
		 Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
