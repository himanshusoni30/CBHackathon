package com.applitools.hackathon.ufg.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.hackathon.ufg.test.BaseTests;

public class Common extends BaseTests {
	static WebElement element = null;
	static int TIMEOUT = 5;

	/**
	 * Method: To verify text
	 * @param driver
	 * @param expected: Expected text
	 * @param id: DOM Id
	 * @return
	 */
	public static boolean verifyText(WebDriver driver, String expected, String id) {
		boolean flag;
		String actual;
		if (isElementPresent(driver, By.id(id))) {
			actual = driver.findElement(By.id(id)).getText();
			if (expected.equals(actual)) {
				flag = true;
			} else {
				flag = false;
				Reporter.log(
						"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
						true);
			}
		} else {
			Reporter.log("Element " + id + "does not exist.", true);
			flag = false;
		}
		return flag;
	}

	/**
	 * Method: To validate the text of element based on attribute
	 * @param driver
	 * @param expected: Expected text
	 * @param id: DOM Id
	 * @param attr: attribute of element
	 * @return
	 */
	public static boolean verifyTextByAttr(WebDriver driver, String expected, String id, String attr) {
		boolean flag;
		String actual;
		if(isElementPresent(driver, By.id(id))) {
			actual = driver.findElement(By.id(id)).getAttribute(attr);
			if (expected.equals(actual)) {
				flag = true;
			} else {
				Reporter.log(
						"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
						true);
				flag = false;
			}
		}else {
			Reporter.log("Element " + id + " does not exist.", true);
			flag = false;
		}
		return flag;	
	}

//	/**
//	 * Method: To validate the n
//	 * @param expected
//	 * @param actual
//	 * @return
//	 */
//	public static boolean verifyNumbers(int expected, int actual) {
//		if (expected == actual) {
//			return true;
//		} else {
//			Reporter.log(
//					"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
//					true);
//			return false;
//		}
//	}

	/**
	 * Method: To check whether Element is present
	 * @param driver
	 * @param locator: Element locator
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, By locator) {
		boolean flag;
		try {
			driver.findElement(locator);
			flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
			Reporter.log("Element "+locator+" is not present.");
		} catch (StaleElementReferenceException e) {
			flag = false;
			Reporter.log("Element "+locator+" is not present.");
		}
		return flag;
	}
	
	/**
	 * Method: To wait for the presence of an element.
	 * @param driver
	 * @param id: DOM Id
	 * @return
	 */
	public static boolean waitForElementVisible(WebDriver driver, String id) {
		boolean flag = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
				if(ele!=null) {
					flag = true;
					break;
				}
			}catch(StaleElementReferenceException e) {
				Reporter.log("Element "+id+" is not found after wait.Reason: "+e);
			}
			attempts++;
		}
		return flag;
	}

	/**
	 * Method: To check that Element is displayed.
	 * @param driver
	 * @param id: DOM Id
	 * @return
	 */
	public static boolean checkElementIsDiplayed(WebDriver driver, String id) {
		boolean flag = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(By.id(id)).isDisplayed();
				flag = true;
				break;
			} catch (StaleElementReferenceException e) {
				Reporter.log("Element "+id+" is not present.Reason: "+e);
			} catch (NoSuchElementException e) {
				Reporter.log("Element "+id+" is not present. Reason: "+e);
			}
			attempts++;
		}
		return flag;
	}

	/**
	 * Method: To open eyes and validate results in Grid.
	 * @param stepName: Name of Test Step
	 * @param testName: Name of Test
	 */
	public static void verifyWindowVisually(String stepName, String testName) {
		eyes.open(driver, "AppliFashion App", testName, new RectangleSize(800, 600));
		if(testName.equalsIgnoreCase("Task 2") && stepName.equalsIgnoreCase("Filter Results")) {
			eyes.check(stepName, Target.region(By.id("product_grid")));
		}else {
			eyes.check(stepName, Target.window().fully());
		}
		eyes.closeAsync();
	}
}
