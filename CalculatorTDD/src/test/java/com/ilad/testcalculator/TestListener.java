package com.ilad.testcalculator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("succeeded", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("skipped", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
