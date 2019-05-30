package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 * TC 1: Swag Lab Title and Login Verification
https://www.saucedemo.com/index.html
@BeforeMethod should contain navigation to the URL and title verification

@Test should contain steps to login and “Products” word verification

@AfterMethod should logOut from the application and close the browser
Collapse

 */
public class Task extends CommonMethods {

	@BeforeMethod
	public void setUpDriver() {
		setUpDriver("chrome", "https://www.saucedemo.com/index.html");
	}

	@Test
	public void task() {

		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();

		boolean label = driver.findElement(By.cssSelector("div.product_label")).isDisplayed();

		if (true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	@AfterMethod
	public void logOutClose() {
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
//		switchToFrame(driver.findElement(By.cssSelector("nav.bm-item-list")));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ContactUs")));
		// or
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#logout_sidebar_link")));
		driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();

		driver.close();
	}

}
