package com.applitools.hackathon.ufg.test;

import org.testng.annotations.Test;

import com.applitools.hackathon.ufg.common.Common;


public class ModernTestV2 extends BaseTests{
	@Test
	public static void launchBrowsersUFG() {
		Common.verifyWindowVisually("Test Modern Test.");
	}
}
