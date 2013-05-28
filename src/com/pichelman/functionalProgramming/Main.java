package com.pichelman.functionalProgramming;

import java.util.Arrays;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Exercise 2.2
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println("Exercise 2.2 Result: " + addList(list));
	}
	
	/*
	 * Exercise 2.2
	 * Write a method that uses recursion to add a list of 
	 * numbers.
	 */
	public static int addList(List<Integer> list) {
		return addList(list, 0);
	}
	
	public static int addList(List<Integer> list, int count) {
		if (list.size() <= 1) { 
			return count + list.get(0);
		} else {
			return addList(list.subList(1, list.size()), count + list.get(0));
		}
	}
}
