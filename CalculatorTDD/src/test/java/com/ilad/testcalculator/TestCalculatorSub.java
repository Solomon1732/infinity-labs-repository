package com.ilad.testcalculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ilad.calculator.Calculator;

@Listeners({com.ilad.testcalculator.TestListener.class})
@Test(groups = {"subtraction"}, dependsOnGroups = {"addition.*"},
alwaysRun = true, description = "Tests the subtraction method")
public class TestCalculatorSub {
	Calculator calculator;

	@BeforeMethod
	public void setup() {
		calculator = new Calculator();
	}

	@Test(dataProvider = "number-cases", dataProviderClass = StaticDataProvider.class)
	public void testSub(int num1, int num2) {
		Assert.assertEquals(calculator.subtraction(num1, num2), num1 - num2);
	}
}
