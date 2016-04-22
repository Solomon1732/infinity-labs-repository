package com.ilad.arrays;

public class SwapIndexes {

	public static <E> void swap(E[] array, int first, int second) {
		E tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}
	
}
