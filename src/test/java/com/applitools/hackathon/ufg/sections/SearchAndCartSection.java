package com.applitools.hackathon.ufg.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.applitools.hackathon.ufg.common.Common;
import com.applitools.hackathon.ufg.test.BaseTests;

public class SearchAndCartSection extends BaseTests {
	private static String banner = "DIV__topbanner__187";

	private static String logo = "logo";
	private static String logoImg = "IMG____9";
	private static String searchBox = "INPUTtext____42";
	private static String searchIcon = "I__headericon__44";
	private static String searchIconM = "A__btnsearchm__59";
	private static String searchBoxM = "INPUTtext__formcontro__62";
	private static String SEARCHMOBILEBTN = "INPUTsubmit__btnfullwid__63";

	private static String topMegaMenuSection = "NAV__colxlcollg__10";
	private static String homeButton = "LI__submenu__22";
	private static String menButton = "LI__megamenusu__24";
	private static String womenButton = "LI__megamenusu__26";
	private static String runningButton = "LI__megamenusu__28";
	private static String trainingButton = "LI__megamenusu__30";

	private static String account = "LI____54";
	private static String wishlist = "LI____51";
	private static String cart = "LI____47";
	private static String cartItems = "STRONG____50";

	private static String sortByBar = "DIV__toolboxele__189";
	private static String sortSelect = "DIV__sortselect__193";
	private static String gridView = "I__tiviewgrid__202";
	private static String listView = "I__tiviewlist__204";
	private static String sortFilterBtn = "LI____205";

	public static void banner(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check top banner is Displayed", banner,
				Common.checkElementIsDiplayed(driver, banner), browser, viewPort(device), device, version));
	}

	public static void logo(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check logo is Displayed", logo,
				Common.checkElementIsDiplayed(driver, logo), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check logo image source", logoImg,
				Common.verifyTextByAttr(driver, "https://demo.applitools.com/grid/img/logo.svg", logoImg, "src"),
				browser, viewPort(device), device, version));
	}

	public static void searchTextBoxAndButton(int task, String browser, String device, SoftAssert asrt, String version) {
		if (device.equalsIgnoreCase("mobile")) {
			asrt.assertTrue(hackathonReporter(task, "Check search icon is Displayed.", searchIconM,
					Common.checkElementIsDiplayed(driver, searchIconM), browser, viewPort(device), device, version));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.id(searchIconM)));
			
			Common.waitForElementVisible(driver, searchBoxM);
			
			asrt.assertTrue(hackathonReporter(task, "Check Search Text Box is Displayed.", searchBoxM,
					Common.checkElementIsDiplayed(driver, searchBoxM), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify Search Text Box placeholder text", searchBoxM,
					Common.verifyTextByAttr(driver, "Search over 10,000 shoes!", searchBoxM, "placeholder"), browser,
					viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check Search Button is Displayed.", SEARCHMOBILEBTN,
					Common.checkElementIsDiplayed(driver, SEARCHMOBILEBTN), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify Search Button text", SEARCHMOBILEBTN,
					Common.verifyTextByAttr(driver, "Search", SEARCHMOBILEBTN, "value"), browser, viewPort(device),
					device,version));

		} else {
			asrt.assertTrue(hackathonReporter(task, "Check Search Text Box is Displayed", searchBox,
					Common.checkElementIsDiplayed(driver, searchBox), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify Search Text Box placeholder text", searchBox,
					Common.verifyTextByAttr(driver, "Search over 10,000 shoes!", searchBox, "placeholder"), browser,
					viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check search icon is Displayed.", searchIcon,
					Common.checkElementIsDiplayed(driver, searchIcon), browser, viewPort(device), device, version));
		}
	}

	public static void headerTopMenu(int task, String browser, String device, SoftAssert asrt, String version) {
		if (device.equalsIgnoreCase("laptop")) {
			asrt.assertTrue(hackathonReporter(task, "Check Top Mega menu section is displayed", topMegaMenuSection,
					Common.checkElementIsDiplayed(driver, topMegaMenuSection), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check HOME button is displayed", homeButton,
					Common.checkElementIsDiplayed(driver, homeButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify HOME button text", homeButton,
					Common.verifyText(driver, "HOME", homeButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check MEN button is displayed", menButton,
					Common.checkElementIsDiplayed(driver, menButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify MEN button text", menButton,
					Common.verifyText(driver, "MEN", menButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check WOMEN button is displayed", womenButton,
					Common.checkElementIsDiplayed(driver, womenButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify WOMEN button text", womenButton,
					Common.verifyText(driver, "WOMEN", womenButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check RUNNING button is displayed", runningButton,
					Common.checkElementIsDiplayed(driver, runningButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify RUNNING button text", runningButton,
					Common.verifyText(driver, "RUNNING", runningButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check TRAINING button is displayed", trainingButton,
					Common.checkElementIsDiplayed(driver, trainingButton), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify TRAINING button text", trainingButton,
					Common.verifyText(driver, "TRAINING", trainingButton), browser, viewPort(device), device, version));
		}
	}

	public static void cartAcntWishList(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check account button is Displayed.", account,
				Common.checkElementIsDiplayed(driver, account), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check cart button is Displayed.", cart,
				Common.checkElementIsDiplayed(driver, cart), browser, viewPort(device), device, version));
		if (device.equalsIgnoreCase("laptop")) {
			asrt.assertTrue(hackathonReporter(task, "Check cart count is Displayed.", cartItems,
					Common.checkElementIsDiplayed(driver, cartItems), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Verify cart count.", cartItems,
					Common.verifyText(driver, "2", cartItems), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check wishlist button is Displayed.", wishlist,
					Common.checkElementIsDiplayed(driver, wishlist), browser, viewPort(device), device, version));
		} else if (device.equalsIgnoreCase("tablet")) {
			Common.waitForElementVisible(driver, cartItems);
			asrt.assertTrue(hackathonReporter(task, "Check cart count is Displayed.", cartItems,
					Common.checkElementIsDiplayed(driver, cartItems), browser, viewPort(device), device, version));

			System.out.println(driver.findElement(By.id(cartItems)).getText());

			asrt.assertTrue(hackathonReporter(task, "Verify cart count.", cartItems,
					Common.verifyText(driver, "2", cartItems), browser, viewPort(device), device, version));
		}
	}

	public static void sortBySection(int task, String browser, String device, SoftAssert asrt, String version) {
		asrt.assertTrue(hackathonReporter(task, "Check Sort By Bar is Displayed.", sortByBar,
				Common.checkElementIsDiplayed(driver, sortByBar), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Check Sort Selection DropDown is Displayed.", sortSelect,
				Common.checkElementIsDiplayed(driver, sortSelect), browser, viewPort(device), device, version));
		if (device.equalsIgnoreCase("laptop")) {
			asrt.assertTrue(hackathonReporter(task, "Check Grid View is Displayed.", gridView,
					Common.checkElementIsDiplayed(driver, gridView), browser, viewPort(device), device, version));
			asrt.assertTrue(hackathonReporter(task, "Check Tile View is Displayed.", listView,
					Common.checkElementIsDiplayed(driver, listView), browser, viewPort(device), device, version));
		} else if (device.equalsIgnoreCase("tablet") || device.equalsIgnoreCase("mobile")) {
			Common.waitForElementVisible(driver, sortFilterBtn);
			asrt.assertTrue(hackathonReporter(task, "Check Filter button is Displayed.", sortFilterBtn,
					Common.checkElementIsDiplayed(driver, sortFilterBtn), browser, viewPort(device), device, version));

			if (device.equalsIgnoreCase("tablet")) {
				asrt.assertTrue(hackathonReporter(task, "Verify Filter button text.", sortFilterBtn,
						Common.verifyText(driver, "Filters", sortFilterBtn), browser, viewPort(device), device, version));
			}
		}
	}

	public static void cartAcntWishListTask3(int task, String browser, String device, SoftAssert asrt, String version) {
		Common.waitForElementVisible(driver, account);
		asrt.assertTrue(hackathonReporter(task, "Check account button is Displayed.", account,
				Common.checkElementIsDiplayed(driver, account), browser, viewPort(device), device, version));
		
		Common.waitForElementVisible(driver, cart);
		asrt.assertTrue(hackathonReporter(task, "Check cart button is Displayed.", cart,
				Common.checkElementIsDiplayed(driver, cart), browser, viewPort(device), device, version));
		
		Common.waitForElementVisible(driver, cartItems);
		asrt.assertTrue(hackathonReporter(task, "Check cart count is Displayed.", cartItems,
				Common.checkElementIsDiplayed(driver, cartItems), browser, viewPort(device), device, version));
		asrt.assertTrue(hackathonReporter(task, "Verify cart count.", cartItems,
				Common.verifyText(driver, "2", cartItems), browser, viewPort(device), device, version));
		
		Common.waitForElementVisible(driver, wishlist);
		asrt.assertTrue(hackathonReporter(task, "Check wishlist button is Displayed.", wishlist,
				Common.checkElementIsDiplayed(driver, wishlist), browser, viewPort(device), device, version));
	}
}
