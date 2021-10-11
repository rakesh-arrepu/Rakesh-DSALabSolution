package com.greatlearning.dsalab;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input String");
		String input = sc.next();
		if (isValidBalancedString(input))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

	public static boolean isValidBalancedString(String input) {
		// Base Condition
		if (input.length() == 0 || input.length() % 2 != 0)
			return false;

		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');

		Stack<Character> stack = new Stack<Character>();
		for (char currentChar : input.toCharArray()) {
			if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
				char closingChar = hm.get(currentChar);
				stack.push(closingChar);
			} else if (!stack.isEmpty()) {
				// Definitely opposite char
				char topChar = stack.peek();
				if (topChar == currentChar)
					stack.pop();
				else
					return false;
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}

}
