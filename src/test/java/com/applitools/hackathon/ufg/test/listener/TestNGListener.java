package com.applitools.hackathon.ufg.test.listener;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		log("Test "+result.getName()+" Started....");
		System.out.println(result.getName()+" test case started");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log("Test '" + result.getName() + "' PASSED");
		System.out.println("The name of the testcase passed is :"+result.getName());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log("Test '" + result.getName() + "' FAILED");
		System.out.println("The name of the testcase failed is :"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log("Test '" + result.getName() + "' SKIPPED");
		System.out.println("The name of the testcase Skipped is :"+result.getName());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
}
