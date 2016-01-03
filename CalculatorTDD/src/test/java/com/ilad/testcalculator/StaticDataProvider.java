package com.ilad.testcalculator;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
	@DataProvider(name = "number-cases")
	public static Object[][] createData() {
		return new Object[][] {{10, 5}, {10, -5},{-10, 5}, {-10, -5}};
	}
}
