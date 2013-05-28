package com.pichelman.functionalProgramming;

import datastructures.ListModule;
import datastructures.ListModule.List;

/**
 * @author kevin.pichelman
 *
 */
public class Chap3 {

	public static void main(String[] args) {
		
		// Exercise 1
		String[] listStr = {"Head", "Second Loser", "Bronze", "Missed the Pedistal!", "Tail"};
		List<String> properList = ListModule.createProperList(listStr);
		printProperList(properList);
		
		
		
	}
	
	// Util class to print our lists.
	public static <T> List<? extends Object> printProperList(List<T> list) {
		if (list.isEmpty()) {
			return ListModule.EMPTY;
		} else {
			System.out.print("Values: " + list.head() + "\n");
			return printProperList(list.tail());
		}
	}
}

