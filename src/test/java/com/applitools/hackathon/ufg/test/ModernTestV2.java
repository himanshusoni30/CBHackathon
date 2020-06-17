package com.applitools.hackathon.ufg.test;

import org.testng.annotations.Test;

import com.applitools.hackathon.ufg.common.Common;
import com.applitools.hackathon.ufg.sections.FilterSection;
import com.applitools.hackathon.ufg.sections.ListOfItemsSection;


public class ModernTestV2 extends BaseTests{
	@Test
	public static void task1() {
		BaseTests.setTheBatch("UFG Hackathon");
		Common.verifyWindowVisually("Cross-Device Elements Test", "Task 1");
	}
	
	@Test
	public static void task2() {
		FilterSection.checkBlackCBAndClickFilterBtnForMT();
		Common.verifyWindowVisually("Filter Results", "Task 2");
	}
	
	@Test
	public static void task3() {
		ListOfItemsSection.clickProductForMT("2");
		Common.verifyWindowVisually("Product Details test", "Task 3");
	}
}
