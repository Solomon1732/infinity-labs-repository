package com.ilad.testcalculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ilad.calculator.Calculator;

@Listeners({com.ilad.testcalculator.TestListener.class})
@Test(groups = {"multiplication"}, description = "Tests the multiplication method")
public class TestCalculatorMul {
	Calculator calculator;

	@BeforeMethod
	public void setup() {
		calculator = new Calculator();
	}

	@Test(dataProvider = "number-cases", dataProviderClass = StaticDataProvider.class)
	public void testMul1(int num1, int num2) {
		Assert.assertEquals(calculator.multiplication(num1, num2), num1 * num2);
	}
	@Parameters({"number_for_case_zero"})
	@Test(description = "Tests multiplication by 0")
	public void testMul2(int number_for_case_zero) {
		Assert.assertEquals(calculator.multiplication(number_for_case_zero, 0),
				number_for_case_zero * 0);
	}

}
