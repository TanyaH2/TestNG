package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
                                    //TestNG
	public static WebDriver driver;

	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			// For mac
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(url);
	}

	/**
	 * This method will Check if data is displayed in the table
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void dataCheck(List<WebElement> element, String text) {

		List<WebElement> cells = element;
		String expected = text;
		for (WebElement cell : cells) {
			String cellText = cell.getText();
			if (cellText.equalsIgnoreCase(expected)) {
				System.out.println(text + " is displayed ");
				break;
//			} else {
//				System.out.println(text + " - text is not present");
			}
		}
	}
	/**
	 * This method will select specified Radio Button
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void radioButton(List<WebElement> element, String text) {

		List<WebElement> maritalStatus = (element);

		for (WebElement maritalStatusOpt : maritalStatus) {

			if (maritalStatusOpt.isEnabled() && maritalStatusOpt.isDisplayed()) {
				String value = maritalStatusOpt.getText();
				if (value.equalsIgnoreCase(text)) {
					maritalStatusOpt.click();
//				}else {
//				System.out.println("No such option of Radio Button is availible");
				}
			}
		}
	}

	/**
	 * This method will select specified Check Boxes
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text, String text2
	 * 
	 */

	public static void checkBox(List<WebElement> element, String text, String text2) {

		List<WebElement> hobbys = element;

		for (WebElement hobby : hobbys) {

			if (hobby.isEnabled() && hobby.isDisplayed()) {
				String value = hobby.getText();
				if (value.equalsIgnoreCase(text) || value.equalsIgnoreCase(text2)) {
					if (hobby.isSelected()) {
						hobby.click();
					}
					hobby.click();
				}
//			} else {
//				System.out.println("No such option of Check Box is availible");
			}

		}
	}
	
	/**
	 * This method will select specified Calendar cell date
	 * 
	 * @author tetianahatley
	 * @param List<WebElement> element, String text
	 * 
	 */
	public static void calendarDateSelection(List<WebElement> element, String wantedDate) {
	List<WebElement> dateCells = element;
	for (WebElement dateOB : dateCells) {
		String dateText = dateOB.getText();

		if (dateText.equals(wantedDate)) {
			dateOB.click();;
		System.out.println("Option with text " + wantedDate + " is selected");
		}
		
	}
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Syntax
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text +" + text + "is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * 
	 * @author Syntax
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
			System.out.println("Option with text " + index + " is selected");
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	/**
	 * Method will send Text
	 * 
	 * @param WebElement element, String value
	 */
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will dismiss alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will get text of an alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
}

///**********************************************************
// * 
// * @param element
// * @param text
// * Below is for Sending Keys
// **********************************************************/
//    public static void sendText(WebElement element, String text) {
//        element.clear();
//        element.sendKeys(text);
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for browserSetUp
//     **********************************************************/
//    
//    public static void browserSetUp(String broswer, String URL) {
//        if(broswer.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "/Users/Syntax/Selenium/chromedriver");
//            driver=new ChromeDriver();
//        }else if(broswer.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "/Users/Syntax/Selenium/geckodriver");
//            driver=new FirefoxDriver();
//        }
//        driver.get(URL);
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for selectByValue
//     **********************************************************/
//    
//    public static void selectByValue(WebElement element,String value) {
//         name=new Select(element);
//        List<WebElement> list=name.getOptions();
//        for(WebElement ele:list) {
//            System.out.println(ele.getText());
//            if(value.equals(ele.getAttribute("value"))) {
//                 name.selectByValue(value);
//            }
//        }
//    }
//    
//    /**********************************************************
//     * 
//     * @param element
//     * @param broswer
//     * Below is for selectByIndex
//     **********************************************************/
//    
//    public static void selectByIndex(WebElement element, int index) {
//        name=new Select(element);
//        List<WebElement> ele=name.getOptions();
//        for(WebElement option:ele) {
//            System.out.println(option.getText());
//            if(ele.size()>index) {
//                name.selectByIndex(index);
//            }
//
//

//FROM AHMET 
//public static void findingElement(String locator, String path, String SendKeyValue) {
//if (locator.equalsIgnoreCase("cssSelector")) {
//	driver.findElement(By.cssSelector(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("xpath")) {
//	driver.findElement(By.xpath(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("id")) {
//	driver.findElement(By.id(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("className")) {
//	driver.findElement(By.className(path)).sendKeys(SendKeyValue);
//}
//if (locator.equalsIgnoreCase("name")) {
//	driver.findElement(By.name(path)).sendKeys(SendKeyValue);
//}
//}
