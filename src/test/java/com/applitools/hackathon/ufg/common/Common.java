package com.applitools.hackathon.ufg.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.hackathon.ufg.test.BaseTests;

public class Common extends BaseTests {
	static WebDriverWait wait = null;
	static WebElement element = null;
	static int TIMEOUT = 5;

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

	public static boolean verifyNumbers(int expected, int actual) {
		if (expected == actual) {
			return true;
		} else {
			Reporter.log(
					"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
					true);
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, By locator) {
		boolean flag;
		try {
			driver.findElement(locator);
			flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
			Reporter.log("Element "+locator+" is not present.");
		}
		return flag;
	}

	public static boolean checkElementIsDiplayed(WebDriver driver, String id) {
		boolean flag = false;
		try {
			flag = driver.findElement(By.id(id)).isDisplayed();
		} catch (NoSuchElementException e) {
			Reporter.log(id + " does not exist.", true);
		}
		return flag;
	}

	public static void verifyWindowVisually(String testName) {
		eyes.open(driver, "AppliFashion App", testName, new RectangleSize(800, 600));
		eyes.check(Target.window().fully().withName("Main Page"));
		eyes.closeAsync();
	}
}
