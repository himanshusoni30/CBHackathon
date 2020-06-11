package com.applitools.hackathon.ufg.sections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.applitools.hackathon.ufg.common.Common;
import com.applitools.hackathon.ufg.test.BaseTests;

public class ListOfItemsSection extends BaseTests {
	private static String gridItem = "grid_item";

	private static String[] names = { "Appli Air x Night", "Appli Air Wildwood ACG", "Appli ACG React Terra",
			"Appli Air Zoom Alpha", "Appli Air Alpha", "Appli Air 98", "Appli Air 720", "Appli Okwahn II",
			"Appli 720" };
	private static String[] newPrice = { "$33.00", "$52.00", "$110.00", "$140.00", "$170.00", "$190.00", "$200.00",
			"$62.00", "$180.00" };
	private static String[] oldPrice = { "$48.00", "$75.00", "", "", "", "", "", "$90.00", "" };

	private static String[] namesT2 = { "Appli Air x Night", "Appli Air 720","" };
	private static String[] newPriceT2 = { "$33.00", "$200.00","" };
	private static String[] oldPriceT2 = { "$48.00", "","" };

	private static String shoeName = "DIV__pageheader__66";
	private static String shoeImg = "shoe_img";
	private static String ratings = "SPAN__rating__76";
	private static String prodDesc = "P____83";
	private static String sizeLabel = "STRONG____90";
	private static String quanLabel = "STRONG____100";
	private static String sizeDD = "DIV__colxlcollg__91";

	private static String quanBar = "DIV__numbersrow__102";
	private static String quanDDVal = "quantity_1";
	private static String quanDDInc = "DIV__incbuttoni__104";
	private static String quanDDDec = "DIV__decbuttoni__105";

	private static String priceBar = "DIV__pricemain__108";
	private static String nPrice = "new_price";
	private static String oPrice = "old_price";
	private static String discount = "discount";

	private static String addToCart = "A__btn__114";

	public static void validateProdGridItemsTask1(int task, String browser, String device, SoftAssert asrt,
			String version) {
		validateProdGridItems(task, browser, device, asrt, version, names, newPrice, oldPrice);
	}

	public static void validateProdGridItemsTask2(int task, String browser, String device, SoftAssert asrt,
			String version) {
		validateProdGridItems(task, browser, device, asrt, version, namesT2, newPriceT2, oldPriceT2);
	}

	public static void validateProdGridItems(int task, String browser, String device, SoftAssert asrt, String version,
			String[] allNames, String[] allNP, String[] allOP) {
		List<WebElement> products = driver.findElements(By.className(gridItem));// *[@id="DIV__griditem__211"]//span[@class='new_price']
		String gridId;
		WebElement ribbon, countdown, header, np, op;
		for (int i = 0; i < products.size(); i++) {
			gridId = products.get(i).getAttribute("id");

			header = driver.findElement(By.xpath(".//*[@id=\"" + gridId + "\"]//h3"));
			asrt.assertTrue(hackathonReporter(task, "Check header label is displayed", header.getAttribute("id"),
					Common.checkElementIsDiplayed(driver, header.getAttribute("id")), browser, viewPort(device),
					device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify header label text", header.getAttribute("id"),
					Common.verifyText(driver, allNames[i], header.getAttribute("id")), browser, viewPort(device),
					device, version));

			np = driver.findElement(By.xpath(".//*[@id=\"" + gridId + "\"]//span[@class=\"new_price\"]"));
			asrt.assertTrue(hackathonReporter(task, "Check price label is displayed for product " + allNames[i],
					np.getAttribute("id"), Common.checkElementIsDiplayed(driver, np.getAttribute("id")), browser,
					viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify price label text for product " + allNames[i],
					np.getAttribute("id"), Common.verifyText(driver, allNP[i], np.getAttribute("id")), browser,
					viewPort(device), device, version));

			if (Common.isElementPresent(driver, By.xpath(".//*[@id=\"" + gridId + "\"]//span[@class=\"old_price\"]"))) {
				op = driver.findElement(By.xpath(".//*[@id=\"" + gridId + "\"]//span[@class=\"old_price\"]"));
				asrt.assertTrue(hackathonReporter(task, "Check old price label is displayed for product " + allNames[i],
						op.getAttribute("id"), Common.checkElementIsDiplayed(driver, op.getAttribute("id")), browser,
						viewPort(device), device, version));
				asrt.assertTrue(hackathonReporter(task, "Verify old price label text for product " + allNames[i],
						op.getAttribute("id"), Common.verifyText(driver, allOP[i], op.getAttribute("id")), browser,
						viewPort(device), device, version));
			}

			if (Common.isElementPresent(driver,
					By.xpath(".//*[@id=\"" + gridId + "\"]//span[@class=\"ribbon off\"]"))) {
				ribbon = driver.findElement(By.xpath(".//*[@id=\"" + gridId + "\"]//span[@class=\"ribbon off\"]"));
				asrt.assertTrue(hackathonReporter(task, "Check discount ribbon is displayed for product " + allNames[i],
						ribbon.getAttribute("id"), Common.checkElementIsDiplayed(driver, ribbon.getAttribute("id")),
						browser, viewPort(device), device, version));
				asrt.assertTrue(hackathonReporter(task, "Verify discount ribbon text for product " + allNames[i],
						ribbon.getAttribute("id"), Common.verifyText(driver, "-30%", ribbon.getAttribute("id")),
						browser, viewPort(device), device, version));
			}

			if (Common.isElementPresent(driver, By.xpath(".//*[@id=\"" + gridId + "\"]//div[@class=\"countdown\"]"))) {
				countdown = driver.findElement(By.xpath(".//*[@id=\"" + gridId + "\"]//div[@class=\"countdown\"]"));
				asrt.assertTrue(hackathonReporter(task, "Check countdown label is displayed for product " + allNames[i],
						countdown.getAttribute("id"),
						Common.checkElementIsDiplayed(driver, countdown.getAttribute("id")), browser, viewPort(device),
						device, version));
				asrt.assertTrue(hackathonReporter(task, "Verify countdown label text for product " + allNames[i],
						countdown.getAttribute("id"),
						Common.verifyText(driver, "1 day left", countdown.getAttribute("id")), browser,
						viewPort(device), device, version));
			}

			if (device.equalsIgnoreCase("mobile") || device.equalsIgnoreCase("tablet")) {
				List<WebElement> ele = driver.findElements(By.xpath(".//*[@id=\"" + gridId + "\"]//ul//li"));
				String li, iconName;
				for (int j = 0; j < ele.size(); j++) {
					li = ele.get(j).getAttribute("id");
					iconName = driver.findElement(By.xpath(".//*[@id=\"" + li + "\"]//span")).getText();
					asrt.assertTrue(hackathonReporter(task,
							"Check icon " + iconName + " is displayed for product " + allNames[i], li,
							Common.checkElementIsDiplayed(driver, li), browser, viewPort(device), device, version));
					asrt.assertTrue(hackathonReporter(task, "Verify icon text for product " + allNames[i], li,
							Common.verifyText(driver, iconName, li), browser, viewPort(device), device, version));
				}
			}
		}
	}

	public static void clickProduct(int task, String browser, String device, SoftAssert asrt,
			String version) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 300)");
		asrt.assertTrue(hackathonReporter(task, "Check Appli Air x Night shoe image is displayed", "A____217",
				Common.checkElementIsDiplayed(driver, "A____217"), browser, viewPort(device), device, version));
		if(Common.isElementPresent(driver, By.id("A____217"))) {
			WebElement btn = driver.findElement(By.id("A____217"));
			js.executeScript("arguments[0].click();", btn);
		}
	}

	public static void validateProductDetailsTask3(int task, String browser, String device, SoftAssert asrt,
			String version) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Common.waitForElementVisible(driver, shoeName);
		asrt.assertTrue(hackathonReporter(task, "Check shoe name is displayed", shoeName,
				Common.checkElementIsDiplayed(driver, shoeName), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify shoe name text", shoeName,
				Common.verifyText(driver, "Appli Air x Night", shoeName), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check shoe image is displayed", shoeImg,
				Common.checkElementIsDiplayed(driver, shoeImg), browser, viewPort(device), device, version));
		
		js.executeScript("window.scrollTo(0, 300)");
		
		Common.waitForElementVisible(driver, addToCart);
		asrt.assertTrue(hackathonReporter(task, "Check rating is displayed", ratings,
				Common.checkElementIsDiplayed(driver, ratings), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify review text", ratings,
				Common.verifyText(driver, "4 reviews", ratings), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check product description is displayed", prodDesc,
				Common.checkElementIsDiplayed(driver, prodDesc), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Verify product description text", prodDesc,
				Common.verifyText(driver, "SKU: MTKRY-001\n"
						+ "These boots are comfortable enough to wear all day. Well made. I love the “look”. Best Used For Casual Everyday Walk fearlessly into the cooler months in the Sorel Joan Of Arctic Wedge II Chelsea Boot. Boasting the iconic wedge platform that's as comfortable as it is stylish, this boot features a waterproof upper",
						prodDesc),
				browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Size label is displayed", sizeLabel,
				Common.checkElementIsDiplayed(driver, sizeLabel), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Size label text", sizeLabel,
				Common.verifyText(driver, "Size", sizeLabel), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Quantity label is displayed", quanLabel,
				Common.checkElementIsDiplayed(driver, quanLabel), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Quantity label text", quanLabel,
				Common.verifyText(driver, "Quantity", quanLabel), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Size dropdown is displayed", sizeDD,
				Common.checkElementIsDiplayed(driver, sizeDD), browser, viewPort(device), device, version));
		
//		asrt.assertTrue(hackathonReporter(task, "Verify Size dropdown default text", quanLabel,
//				driver.findElement(By.xpath("//div[@class='nice-select wide']")).getText().equalsIgnoreCase("Small (S)"),
//				browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Quantity increase decrease bar is displayed", quanBar,
				Common.checkElementIsDiplayed(driver, quanBar), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Quantity default value", quanDDVal,
				Common.verifyTextByAttr(driver, "1", quanDDVal, "value"), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check Quantity increase button is displayed", quanDDInc,
				Common.checkElementIsDiplayed(driver, quanDDInc), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check Quantity decrease button is displayed", quanDDDec,
				Common.checkElementIsDiplayed(driver, quanDDDec), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Price bar is displayed", priceBar,
				Common.checkElementIsDiplayed(driver, priceBar), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify New Price value", nPrice,
				Common.verifyText(driver, "$33.00", nPrice), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Old Price value", oPrice,
				Common.verifyText(driver, "$48.00", oPrice), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Discount value", discount,
				Common.verifyText(driver, "-30% discount", discount), browser, viewPort(device), device, version));

		asrt.assertTrue(hackathonReporter(task, "Check Add to Cart button is displayed", addToCart,
				Common.checkElementIsDiplayed(driver, addToCart), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Add To Cart button text", addToCart,
				Common.verifyText(driver, "Add to Cart", addToCart), browser, viewPort(device), device, version));
	}
}
