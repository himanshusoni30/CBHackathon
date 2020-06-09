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

public class TrailerSection extends BaseTests {
	private static String quickLinks = "DIV__collgcolmd__420";
	private static String quickLinksHead = "H3____421";
	private static String[] ql = { "About us", "Faq", "Help", "My account", "Blog", "Contacts" };

	private static String contactLinks = "DIV__collgcolmd__436";
	private static String contactLinksHead = "H3____437";
	private static String[] cl = { "155 Bovet Rd #600\nSan Mateo, CA 94402", "srd@applitools.com" };
	private static String[] iconCon = { "Home", "Email" };
	
	private static String kit = "DIV__collgcolmd__446";
	private static String kitHead = "H3____447";
	private static String nlTextBox = "email_newsletter";
	private static String nlBtn = "submit-newsletter";
	
	private static String lang = "LI____458";
	private static String currency = "LI____465";
	private static String tnc = "LI____472";
	private static String privacy = "LI____474";
	private static String cpr = "LI____476";
	
	private static JavascriptExecutor js;
	private static WebDriverWait w = new WebDriverWait(driver, 5);

	public static void quickLinksSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check Quick Links section is Displayed", quickLinks,
				Common.checkElementIsDiplayed(driver, quickLinks), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Quick Links text", quickLinksHead,
				Common.verifyText(driver, "QUICK LINKS", quickLinksHead), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinks))) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			w.until(ExpectedConditions.elementToBeClickable(By.id(quickLinks)));
			driver.findElement(By.id(quickLinks)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + quickLinks + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {
			w.until(ExpectedConditions.visibilityOf(l.get(i)));
			String link = l.get(i).getAttribute("id");
			asrt.assertTrue(hackathonReporter(task, "Check " + ql[i] + " link in Quick Links section is Displayed",
					link, Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify text of " + ql[i] + " link in Quick Links section", link,
					Common.verifyText(driver, ql[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinks))) {
//			w.until(ExpectedConditions.elementToBeClickable(By.id(quickLinks)));
			driver.findElement(By.id(quickLinks)).click();
		}
	}

	public static void contactSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check Contacts section is Displayed", contactLinks,
				Common.checkElementIsDiplayed(driver, contactLinks), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Contacts text", contactLinksHead,
				Common.verifyText(driver, "CONTACTS", contactLinksHead), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinks))) {
//			w.until(ExpectedConditions.elementToBeClickable(By.id(contactLinks)));
			driver.findElement(By.id(contactLinks)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + contactLinks + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {
			w.until(ExpectedConditions.visibilityOf(l.get(i)));
			String link = l.get(i).getAttribute("id");
//			System.out.println(l.get(i).getText());
			WebElement icon = driver.findElement(By.xpath(".//*[@id='" + link + "']//i"));

			asrt.assertTrue(hackathonReporter(task, "Check " + iconCon[i] + " icon in Contacts section is Displayed",
					icon.getAttribute("id"), Common.checkElementIsDiplayed(driver, icon.getAttribute("id")), browser,
					viewPort(device), device, version));

			asrt.assertTrue(hackathonReporter(task, "Check " + cl[i] + " in Contacts section is Displayed", link,
					Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify text of " + cl[i] + " in Contacts section", link,
					Common.verifyText(driver, cl[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinks))) {
//			w.until(ExpectedConditions.elementToBeClickable(By.id(contactLinks)));
			driver.findElement(By.id(contactLinks)).click();
		}
	}
	
	public static void kitSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check Keep In Touch section is Displayed", kit,
				Common.checkElementIsDiplayed(driver, kit), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Keep In Touch text", kitHead,
				Common.verifyText(driver, "KEEP IN TOUCH", kitHead), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kit))) {
//			w.until(ExpectedConditions.elementToBeClickable(By.id(kit)));
			driver.findElement(By.id(kit)).click();
		}
		
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(nlTextBox))));
		asrt.assertTrue(hackathonReporter(task, "Check newsletter textbox in Keep In Touch section is Displayed", nlTextBox,
				Common.checkElementIsDiplayed(driver, nlTextBox), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify newsletter textbox placeholder text in Keep In Touch section", nlTextBox,
				Common.verifyTextByAttr(driver, "Your email", nlTextBox, "placeholder"), browser, viewPort(device), device, version));
		
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(nlBtn))));
		asrt.assertTrue(hackathonReporter(task, "Check newsletter button in Keep In Touch section is Displayed", nlBtn,
				Common.checkElementIsDiplayed(driver, nlBtn), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kit))) {
//			w.until(ExpectedConditions.elementToBeClickable(By.id(kit)));
			driver.findElement(By.id(kit)).click();
		}
	}
	
	public static void footerElements(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check language selector is Displayed", lang,
				Common.checkElementIsDiplayed(driver, lang), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check currency dropdown is Displayed", currency,
				Common.checkElementIsDiplayed(driver, currency), browser, viewPort(device), device, version));
		
		asrt.assertTrue(hackathonReporter(task, "Check Terms and Conditions is Displayed", tnc,
				Common.checkElementIsDiplayed(driver, tnc), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Terms and Conditions text", tnc,
				Common.verifyText(driver, "Terms and conditions", tnc), browser, viewPort(device), device, version));
		
		asrt.assertTrue(hackathonReporter(task, "Check Privacy is Displayed", privacy,
				Common.checkElementIsDiplayed(driver, privacy), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Privacy text", privacy,
				Common.verifyText(driver, "Privacy", privacy), browser, viewPort(device), device, version));
		
		asrt.assertTrue(hackathonReporter(task, "Check Copyright is Displayed", cpr,
				Common.checkElementIsDiplayed(driver, cpr), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify Copyright text", cpr,
				Common.verifyText(driver, "© 2020 Applitools", cpr), browser, viewPort(device), device, version));
	}
}
