package com.applitools.hackathon.ufg.test;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TraditionalTestV1 extends BaseTests {
	private static SoftAssert asrt;

	@Test
	@Parameters({ "browser", "width", "device" })
	public static void launchBrowsers(String browser, String width, String device) {
		asrt = new SoftAssert();
		String viewport = width + "X700";
		asrt.assertTrue(
				hackathonReporter(
						1, "CheckTitle", "INPUTtext____42", driver.findElement(By.id("INPUTtext____42"))
								.getAttribute("placeholder").equals("Search over 10,000 shoes!"),
						browser, viewport, device));
	}
}
