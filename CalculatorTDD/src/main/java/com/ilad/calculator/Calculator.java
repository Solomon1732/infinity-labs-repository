package com.ilad.calculator;

/**
 * A simple Calculator class
 * @author Shlomi Reuveni
 * @since Dec 21 2015
 */
public class Calculator {
	/**
	 * Adds two numbers and returns the result
	 * @param num1 the first number
	 * @param num2 the second number
	 * @return the addition of i and j
	 */
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	/**
	 * Subtracts the subtrahend from the minuend
	 * @param minuend the number to be subtracted from
	 * @param subtrahend the number subtracted from the minuend
	 * @return the result of the subtraction
	 */
	public int subtraction(int minuend, int subtrahend) {
		return minuend - subtrahend;
	}

	/**
	 * Multiplies two numbers
	 * @param num1 the first number
	 * @param num2 the second number
	 * @return the result of the multiplication
	 */
	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	/**
	 * Divides the numerator by the denominator. A denominator of 0 results in
	 * an <b>ArithmaticException</b> instance to be thrown
	 * @param numerator the number to be divided
	 * @param denominator the number which the numerator is divided by
	 * @return the result of the division
	 */
	public int division(int numerator, int denominator) {
		return numerator / denominator;
	}

}
