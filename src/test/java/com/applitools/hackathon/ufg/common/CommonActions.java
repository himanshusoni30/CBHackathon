package com.applitools.hackathon.ufg.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.hackathon.ufg.test.BaseTests;

public class CommonActions extends BaseTests {
	static WebDriverWait wait = null;
	static WebElement element = null;
	static int TIMEOUT = 5;

	public static void click(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, TIMEOUT);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		Reporter.log("Click on locator " + locator, true);
	}

	public static void fillText(WebDriver driver, By locator, String text) {
		wait = new WebDriverWait(driver, TIMEOUT);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
		Reporter.log("Fill text in text box with locator " + locator, true);
	}

	public static void verifyText(String expected, String actual, SoftAssert asrt) {
		if (expected.equals(actual)) {
			asrt.assertEquals(actual, expected);
			Reporter.log("Expected matches with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
					true);
		} else {
			Reporter.log(
					"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
					true);
			asrt.fail("Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual);
		}
	}

	public static void verifyNumbers(int expected, int actual, SoftAssert asrt) {
		if (expected == actual) {
			asrt.assertEquals(actual, expected);
			Reporter.log("Expected matches with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
					true);
		} else {
			Reporter.log(
					"Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual,
					true);
			asrt.fail("Expected does not match with Actual. Expected Text: " + expected + " | Actual Text: " + actual);
		}
	}

	public static boolean checkElementExist(WebDriver driver, By locator) {
		boolean present;
		try {
			driver.findElement(locator);
			Reporter.log(locator + " exist.", true);
			present = true;
		} catch (NoSuchElementException e) {
			Reporter.log(locator + " does exist.", true);
			present = false;
		}
		return present;
	}

	public static void verifyWindowVisually(String testName) {
		eyes.open(driver, "Hackathon App", testName, new RectangleSize(800, 600));
		eyes.check(Target.window().fully().withName("Main Page"));
		eyes.closeAsync();
	}
}
