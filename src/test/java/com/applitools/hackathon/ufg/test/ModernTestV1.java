package com.applitools.hackathon.ufg.test;

import org.testng.annotations.Test;

import com.applitools.hackathon.ufg.common.CommonActions;


public class ModernTestV1 extends BaseTests{
	@Test
	public static void launchBrowsersUFG() {
		CommonActions.verifyWindowVisually("Test Modern Test.");
	}
}
