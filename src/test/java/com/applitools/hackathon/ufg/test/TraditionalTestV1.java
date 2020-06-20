package com.applitools.hackathon.ufg.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.applitools.hackathon.ufg.sections.FilterSection;
import com.applitools.hackathon.ufg.sections.ListOfItemsSection;
import com.applitools.hackathon.ufg.sections.SearchAndCartSection;
import com.applitools.hackathon.ufg.sections.TrailerSection;

public class TraditionalTestV1 extends BaseTests {

	@Test
	@Parameters({ "browser", "device", "version" })
	public static void task1(String browser, String device, String version) {
		SearchAndCartSection.logo(1, browser, device, asrt, version);
		if(device.equalsIgnoreCase("laptop")) {
			SearchAndCartSection.headerTopMenu(1, browser, device, asrt, version);
		}
		SearchAndCartSection.banner(1, browser, device, asrt, version);
		SearchAndCartSection.sortBySection(1, browser, device, asrt, version);
		SearchAndCartSection.searchTextBoxAndButton(1, browser, device, asrt, version);
		SearchAndCartSection.cartAcntWishList(1, browser, device, asrt, version);
		FilterSection.filterColumn(1, browser, device, asrt, version);
		ListOfItemsSection.validateProdGridItemsTask1(1, browser, device, asrt, version);
		TrailerSection.quickLinksSection(1, browser, device, asrt, version);
		TrailerSection.contactSection(1, browser, device, asrt, version);
		TrailerSection.kitSection(1, browser, device, asrt, version);
		TrailerSection.footerElements(1, browser, device, asrt, version);
	}

	@Test
	@Parameters({ "browser", "device", "version" })
	public static void task2(String browser, String device, String version) {
		FilterSection.checkBlackCBAndClickFilterBtn(2, browser, device, asrt, version);
		ListOfItemsSection.validateProdGridItemsTask2(2, browser, device, asrt, version);
	}

	@Test
	@Parameters({ "browser", "device", "version" })
	public static void task3(String browser, String device, String version) {
		ListOfItemsSection.clickProduct(3, browser, device, asrt, version);
		SearchAndCartSection.logo(3, browser, device, asrt, version);
		SearchAndCartSection.searchTextBoxAndButton(3, browser, device, asrt, version);
		SearchAndCartSection.cartAcntWishListTask3(3, browser, device, asrt, version);
		ListOfItemsSection.validateProductDetailsTask3(3, browser, device, asrt, version);
	}
}
