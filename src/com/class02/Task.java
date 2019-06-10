package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 *  TC 1: OrangeHRM Title Validation
 *
 *  TC 2: OrangeHRM Successful Login 
 *  
 * https://opensource-demo.orangehrmlive.com/
 * Please make sure to use the following:
 * annotations:
 * 
	*@BeforeMethod
	*@AfterMethod
	*@Test
 *
 *  What would you do if you do not want to execute any specific test case?
 *  What would you do if you want to execute any specific test case first?
 */
public class Task extends CommonMethods{

	@BeforeMethod
	public void title() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		String logo=driver.findElement(By.cssSelector("div#divLogo")).getText();
		System.out.println(logo);
		String log="OrangeHRM";
		if(logo.equals(log)) {
			System.out.println("logo is correct");
		}else {
			System.out.println("No");
		}
	}
	
	@Test
     public void logIn() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.xpath("//span[text()='Password']")), "admin123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
	}
	
	@AfterMethod
     public void close()  {
		driver.close();
	}
	
}

//@BeforeMethod
//public static void navig() {
//	setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
//}
//@Test(priority =0)
//public static void valid() {
//	String title=driver.getTitle();
//	String exp ="OrangeHRM";
//	System.out.println(title);
//	if(exp.equalsIgnoreCase(title) ){
//		System.out.println("correct");
//	}
//	else {
//		System.out.println("NOT correct");
//	}
//}
//
//@Test(priority=1)
//public static void loginWeb(){
//	sendText(driver.findElement(By.xpath("//*[@id='txtUsername']")), "Admin");
//	sendText(driver.findElement(By.xpath("//*[@id='txtPassword']")), "admin123");
//	driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
//}
//@AfterMethod
//public static void logout(){
//	driver.close();
//}
//}