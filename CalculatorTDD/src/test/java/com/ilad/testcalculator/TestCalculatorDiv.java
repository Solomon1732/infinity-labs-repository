package com.ilad.testcalculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ilad.calculator.Calculator;

@Listeners({com.ilad.testcalculator.TestListener.class})
@Test(groups = {"division"}, description = "Tests the division method")
public class TestCalculatorDiv {
	Calculator calculator;

	@BeforeMethod
	public void setup() {
		calculator = new Calculator();
	}

	@Test(dataProvider = "number-cases", dataProviderClass = StaticDataProvider.class)
	public void testDiv1(int num1, int num2) {
		Assert.assertEquals(calculator.division(num1, num2), num1 / num2);		
	}

	@Parameters({"number_for_case_zero"})
	@Test(description = "Tests division of 0 by a non-zero number")
	public void testDiv2(int number_for_case_zero) {
		Assert.assertEquals(calculator.division(0, number_for_case_zero), 0);
	}

	@Parameters({"number_for_case_zero"})
	@Test(expectedExceptions = {ArithmeticException.class},
			description = "Tests division af a non-zero number by 0")
	public void testDiv3(int number_for_case_zero) {
		calculator.division(number_for_case_zero, 0);
	}

	@Test(expectedExceptions = {ArithmeticException.class},
			description = "Tests division of 0 by 0")
	public void testDiv4() {
		calculator.division(0, 0);
	}
}
