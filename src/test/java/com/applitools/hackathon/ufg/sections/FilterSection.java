package com.applitools.hackathon.ufg.sections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.applitools.hackathon.ufg.common.Common;
import com.applitools.hackathon.ufg.test.BaseTests;

public class FilterSection extends BaseTests {

	private static String filterCol = "filter_col";

	private static String filterColTypeSection = "DIV__filtertype__73";
	private static String typeHead = "H4____74";
	private static String typeSection = "UL____77";
	private static String[] typeItems = { "Soccer", "Basketball", "Running", "Training" };
	private static int[] typeNoOfItems = { 2, 1, 2, 3 };

	private static String filterColColorsSection = "DIV__filtertype__98";
	private static String colorHead = "H4____99";
	private static String colorSection = "UL____102";
	private static String[] colorItems = { "Black", "White", "Blue", "Green", "Yellow" };
	private static int[] colorNoOfItems = { 2, 1, 3, 1, 1 };
	
	private static String filterColBrandSection = "DIV__filtertype__128";
	private static String brandHead = "H4____129";
	private static String brandSection = "UL____132";
	private static String[] brandItems = { "Adibas", "Mykey", "Bans", "Over Armour", "ImBalance" };
	private static int[] brandNoOfItems = { 2, 2, 2, 2, 1 };
	
	private static String filterColPriceSection = "DIV__filtertype__158";
	private static String priceHead = "H4____159";
	private static String priceSection = "UL____162";
	private static String[] priceItems = { "$0 - $50", "$50 - $100", "$100 - $150", "$150 - $500" };
	private static int[] priceNoOfItems = { 1, 2, 2, 4 };
	
	private static String filterColFilterBTN = "filterBtn";
	private static String filterColResetBTN = "resetBtn";
	
	public static void filterColumn(int task, String browser, String device, SoftAssert asrt, String version) {
		if (device.equalsIgnoreCase("laptop")) {
			asrt.assertTrue(hackathonReporter(task, "Check Filter Column is displayed", filterCol,
					Common.checkElementIsDiplayed(driver, filterCol), browser, viewPort(device), device, version));

			asrt.assertTrue(hackathonReporter(task, "Check Type filter is displayed", filterColTypeSection,
					Common.checkElementIsDiplayed(driver, filterColTypeSection), browser, viewPort(device), device, version));
			
			asrt.assertTrue(hackathonReporter(task, "Verify Type filter heading", typeHead,
					Common.verifyText(driver, "type", typeHead), browser, viewPort(device), device, version));
			
			filtersValidation(driver, typeSection, typeItems, typeNoOfItems, task, browser, device, asrt, version);

			asrt.assertTrue(hackathonReporter(task, "Check Colors filter is displayed", filterColColorsSection,
					Common.checkElementIsDiplayed(driver, filterColColorsSection), browser, viewPort(device), device, version));
			
			asrt.assertTrue(hackathonReporter(task, "Verify Color filter heading", colorHead,
					Common.verifyText(driver, "colors", colorHead), browser, viewPort(device), device, version));
			
			filtersValidation(driver, colorSection, colorItems, colorNoOfItems, task, browser, device, asrt, version);

			asrt.assertTrue(hackathonReporter(task, "Check Brands filter is displayed", filterColBrandSection,
					Common.checkElementIsDiplayed(driver, filterColBrandSection), browser, viewPort(device), device, version));
			
			asrt.assertTrue(hackathonReporter(task, "Verify Brands filter heading", brandHead,
					Common.verifyText(driver, "brands", brandHead), browser, viewPort(device), device, version));
			
			filtersValidation(driver, brandSection, brandItems, brandNoOfItems, task, browser, device, asrt, version);

			asrt.assertTrue(hackathonReporter(task, "Check Price filter is displayed", filterColPriceSection,
					Common.checkElementIsDiplayed(driver, filterColPriceSection), browser, viewPort(device), device, version));
			
			asrt.assertTrue(hackathonReporter(task, "Verify Price filter heading", priceHead,
					Common.verifyText(driver, "price", priceHead), browser, viewPort(device), device, version));
			
			filtersValidation(driver, priceSection, priceItems, priceNoOfItems, task, browser, device, asrt, version);

			asrt.assertTrue(hackathonReporter(task, "Check Filter button is displayed", filterColFilterBTN,
					Common.checkElementIsDiplayed(driver, filterColFilterBTN), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify Filter button text", filterColFilterBTN,
					Common.verifyText(driver, "Filter", filterColFilterBTN), browser, viewPort(device), device, version));

			asrt.assertTrue(hackathonReporter(task, "Check Reset button is displayed", filterColResetBTN,
					Common.checkElementIsDiplayed(driver, filterColResetBTN), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify Reset button text", filterColResetBTN,
					Common.verifyText(driver, "Reset", filterColResetBTN), browser, viewPort(device), device, version));
		}
	}

	public static void filtersValidation(WebDriver driver, String id, String[] items, int[] num, int task,
			String browser, String device, SoftAssert asrt, String version) {
		List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"" + id + "\"]//li"));
		for (int i = 0; i < ele.size(); i++) {
			String[] arr = ele.get(i).getText().split("\\r?\\n");
			asrt.assertTrue(hackathonReporter(task, "Check filter " + items[i] + " with quantity "+num[i]+" is displayed", ele.get(i).getAttribute("id"),
					(arr[0].trim().equalsIgnoreCase(items[i]) && Integer.parseInt(arr[1].trim())==num[i]), browser, viewPort(device), device, version));
		}
	}
	
	public static void checkBlackCBAndClickFilterBtn(int task, String browser, String device, SoftAssert asrt, String version) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(driver.findElement(By.id("SPAN__checkmark__107")).isDisplayed()) {
			driver.findElement(By.id("SPAN__checkmark__107")).click();
			driver.findElement(By.id(filterColFilterBTN)).click();
			asrt.assertTrue(hackathonReporter(task, "Check Product Grid is displayed", "product_grid",
					Common.checkElementIsDiplayed(driver, "product_grid"), browser, viewPort(device), device, version));
		}else {
			js.executeScript("arguments[0].click();", driver.findElement(By.id("ti-filter")));
			Common.waitForElementVisible(driver, filterCol);
			js.executeScript("arguments[0].click();", driver.findElement(By.id("SPAN__checkmark__107")));
			js.executeScript("arguments[0].click();", driver.findElement(By.id(filterColFilterBTN)));
			Common.waitForElementVisible(driver, "product_grid");
			asrt.assertTrue(hackathonReporter(task, "Check Product Grid is displayed", "product_grid",
					Common.checkElementIsDiplayed(driver, "product_grid"), browser, viewPort(device), device, version));
		}
	}
}
