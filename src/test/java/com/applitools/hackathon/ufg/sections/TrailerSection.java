package com.applitools.hackathon.ufg.sections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
	
	private static String quickLinksv2 = "DIV__collgcolmd__421";
	private static String quickLinksHeadv2 = "H3__opened__422";

	private static String contactLinksv2 = "DIV__collgcolmd__437";
	private static String contactLinksHeadv2 = "H3____438";

	private static String kitv2 = "DIV__collgcolmd__447";
	private static String kitHeadv2 = "H3____448";
	private static String nlTextBoxv2 = "email_newsletter";
	private static String nlBtnv2 = "submit-newsletter";

	private static String langv2 = "LI____459";
	private static String currencyv2 = "LI____466";
	private static String tncv2 = "LI____473";
	private static String privacyv2 = "LI____475";
	private static String cprv2 = "LI____477";
	
	private static JavascriptExecutor js;

	/**
	 * Method: To validate Quick Links section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void quickLinksSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Quick Links section is Displayed", quickLinks,
				Common.checkElementIsDiplayed(driver, quickLinks), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Quick Links text", quickLinksHead,
				Common.verifyText(driver, "QUICK LINKS", quickLinksHead), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinks))) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Common.waitForElementVisible(driver, quickLinks);
			driver.findElement(By.id(quickLinks)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + quickLinks + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {
			String link = l.get(i).getAttribute("id");
			asrt.assertTrue(Reporter(task, "Check " + ql[i] + " link in Quick Links section is Displayed",
					link, Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(Reporter(task, "Verify text of " + ql[i] + " link in Quick Links section", link,
					Common.verifyText(driver, ql[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinks))) {

			Common.waitForElementVisible(driver, quickLinks);
			driver.findElement(By.id(quickLinks)).click();
		}
	}

	/**
	 * Method: To validate Contact section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void contactSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Contacts section is Displayed", contactLinks,
				Common.checkElementIsDiplayed(driver, contactLinks), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Contacts text", contactLinksHead,
				Common.verifyText(driver, "CONTACTS", contactLinksHead), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinks))) {

			Common.waitForElementVisible(driver, contactLinks);
			driver.findElement(By.id(contactLinks)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + contactLinks + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {

			String link = l.get(i).getAttribute("id");
			WebElement icon = driver.findElement(By.xpath(".//*[@id='" + link + "']//i"));

			asrt.assertTrue(Reporter(task, "Check " + iconCon[i] + " icon in Contacts section is Displayed",
					icon.getAttribute("id"), Common.checkElementIsDiplayed(driver, icon.getAttribute("id")), browser,
					viewPort(device), device, version));

			asrt.assertTrue(Reporter(task, "Check " + cl[i] + " in Contacts section is Displayed", link,
					Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(Reporter(task, "Verify text of " + cl[i] + " in Contacts section", link,
					Common.verifyText(driver, cl[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinks))) {

			Common.waitForElementVisible(driver, contactLinks);
			driver.findElement(By.id(contactLinks)).click();
		}
	}
	
	/**
	 * Method: To validate Keep In Touch section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void kitSection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Keep In Touch section is Displayed", kit,
				Common.checkElementIsDiplayed(driver, kit), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Keep In Touch text", kitHead,
				Common.verifyText(driver, "KEEP IN TOUCH", kitHead), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kit))) {

			Common.waitForElementVisible(driver, kit);
			driver.findElement(By.id(kit)).click();
		}
		
		Common.waitForElementVisible(driver, nlTextBox);
		asrt.assertTrue(Reporter(task, "Check newsletter textbox in Keep In Touch section is Displayed", nlTextBox,
				Common.checkElementIsDiplayed(driver, nlTextBox), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify newsletter textbox placeholder text in Keep In Touch section", nlTextBox,
				Common.verifyTextByAttr(driver, "Your email", nlTextBox, "placeholder"), browser, viewPort(device), device, version));
		
		Common.waitForElementVisible(driver, nlBtn);
		asrt.assertTrue(Reporter(task, "Check newsletter button in Keep In Touch section is Displayed", nlBtn,
				Common.checkElementIsDiplayed(driver, nlBtn), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kit))) {
			Common.waitForElementVisible(driver, kit);
			driver.findElement(By.id(kit)).click();
		}
	}
	
	/**
	 * Method: To validate Language, Currency, Terms and Condition, Privacy and Copyright fields present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void footerElements(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check language selector is Displayed", lang,
				Common.checkElementIsDiplayed(driver, lang), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Check currency dropdown is Displayed", currency,
				Common.checkElementIsDiplayed(driver, currency), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Terms and Conditions is Displayed", tnc,
				Common.checkElementIsDiplayed(driver, tnc), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Terms and Conditions text", tnc,
				Common.verifyText(driver, "Terms and conditions", tnc), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Privacy is Displayed", privacy,
				Common.checkElementIsDiplayed(driver, privacy), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Privacy text", privacy,
				Common.verifyText(driver, "Privacy", privacy), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Copyright is Displayed", cpr,
				Common.checkElementIsDiplayed(driver, cpr), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Copyright text", cpr,
				Common.verifyText(driver, "© 2020 Applitools", cpr), browser, viewPort(device), device, version));
	}
	
	
	/**
	 * Method: To validate Quick Links section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void quickLinksSectionV2(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Quick Links section is Displayed", quickLinksv2,
				Common.checkElementIsDiplayed(driver, quickLinksv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Quick Links text", quickLinksHeadv2,
				Common.verifyText(driver, "QUICK LINKS", quickLinksHeadv2), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinksv2))) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Common.waitForElementVisible(driver, quickLinksv2);
			driver.findElement(By.id(quickLinksv2)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + quickLinksv2 + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {
			String link = l.get(i).getAttribute("id");
			asrt.assertTrue(Reporter(task, "Check " + ql[i] + " link in Quick Links section is Displayed",
					link, Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(Reporter(task, "Verify text of " + ql[i] + " link in Quick Links section", link,
					Common.verifyText(driver, ql[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(quickLinksv2))) {

			Common.waitForElementVisible(driver, quickLinksv2);
			driver.findElement(By.id(quickLinksv2)).click();
		}
	}

	/**
	 * Method: To validate Contact section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void contactSectionV2(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Contacts section is Displayed", contactLinksv2,
				Common.checkElementIsDiplayed(driver, contactLinksv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Contacts text", contactLinksHeadv2,
				Common.verifyText(driver, "CONTACTS", contactLinksHeadv2), browser, viewPort(device), device, version));

		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinksv2))) {

			Common.waitForElementVisible(driver, contactLinksv2);
			driver.findElement(By.id(contactLinksv2)).click();
		}

		List<WebElement> l = driver.findElements(By.xpath(".//*[@id='" + contactLinksv2 + "']//ul//li"));
		for (int i = 0; i < l.size(); i++) {

			String link = l.get(i).getAttribute("id");
			WebElement icon = driver.findElement(By.xpath(".//*[@id='" + link + "']//i"));

			asrt.assertTrue(Reporter(task, "Check " + iconCon[i] + " icon in Contacts section is Displayed",
					icon.getAttribute("id"), Common.checkElementIsDiplayed(driver, icon.getAttribute("id")), browser,
					viewPort(device), device, version));

			asrt.assertTrue(Reporter(task, "Check " + cl[i] + " in Contacts section is Displayed", link,
					Common.checkElementIsDiplayed(driver, link), browser, viewPort(device), device, version));
			asrt.assertTrue(Reporter(task, "Verify text of " + cl[i] + " in Contacts section", link,
					Common.verifyText(driver, cl[i], link), browser, viewPort(device), device, version));
		}
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(contactLinksv2))) {

			Common.waitForElementVisible(driver, contactLinksv2);
			driver.findElement(By.id(contactLinksv2)).click();
		}
	}
	
	/**
	 * Method: To validate Keep In Touch section present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void kitSectionV2(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check Keep In Touch section is Displayed", kitv2,
				Common.checkElementIsDiplayed(driver, kitv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Keep In Touch text", kitHeadv2,
				Common.verifyText(driver, "KEEP IN TOUCH", kitHeadv2), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kitHeadv2))) {

			Common.waitForElementVisible(driver, kitHeadv2);
			driver.findElement(By.id(kitHeadv2)).click();
		}
		
		Common.waitForElementVisible(driver, nlTextBoxv2);
		asrt.assertTrue(Reporter(task, "Check newsletter textbox in Keep In Touch section is Displayed", nlTextBoxv2,
				Common.checkElementIsDiplayed(driver, nlTextBoxv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify newsletter textbox placeholder text in Keep In Touch section", nlTextBoxv2,
				Common.verifyTextByAttr(driver, "Your email", nlTextBoxv2, "placeholder"), browser, viewPort(device), device, version));
		
		Common.waitForElementVisible(driver, nlBtnv2);
		asrt.assertTrue(Reporter(task, "Check newsletter button in Keep In Touch section is Displayed", nlBtnv2,
				Common.checkElementIsDiplayed(driver, nlBtnv2), browser, viewPort(device), device, version));
		
		if (device.equalsIgnoreCase("mobile") && Common.isElementPresent(driver, By.id(kitv2))) {
			Common.waitForElementVisible(driver, kitv2);
			driver.findElement(By.id(kitv2)).click();
		}
	}
	
	/**
	 * Method: To validate Language, Currency, Terms and Condition, Privacy and Copyright fields present at bottom of Page.
	 * @param task: 1, 2 or 3
	 * @param browser: Chrome, Firefox or Edge
	 * @param device: Laptop, Tablet or Mobile
	 * @param asrt: 
	 * @param version: 1 or 2
	 */
	public static void footerElementsV2(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(Reporter(task, "Check language selector is Displayed", langv2,
				Common.checkElementIsDiplayed(driver, langv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Check currency dropdown is Displayed", currencyv2,
				Common.checkElementIsDiplayed(driver, currencyv2), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Terms and Conditions is Displayed", tncv2,
				Common.checkElementIsDiplayed(driver, tncv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Terms and Conditions text", tncv2,
				Common.verifyText(driver, "Terms and conditions", tncv2), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Privacy is Displayed", privacyv2,
				Common.checkElementIsDiplayed(driver, privacyv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Privacy text", privacyv2,
				Common.verifyText(driver, "Privacy", privacyv2), browser, viewPort(device), device, version));
		
		asrt.assertTrue(Reporter(task, "Check Copyright is Displayed", cprv2,
				Common.checkElementIsDiplayed(driver, cprv2), browser, viewPort(device), device, version));
		asrt.assertTrue(Reporter(task, "Verify Copyright text", cprv2,
				Common.verifyText(driver, "© 2020 Applitools", cprv2), browser, viewPort(device), device, version));
	}
}
