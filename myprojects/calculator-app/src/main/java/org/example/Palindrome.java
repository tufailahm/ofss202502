package org.example;

public class Palindrome {

	public boolean checkPalindrome(String word) {
		String reverse = "";

		if (word.equalsIgnoreCase("ofss") || word.equalsIgnoreCase("oracle")) {
			throw new InvalidWordException();
		} else {
			int length = word.length();
			for (int i = length - 1; i >= 0; i--)
				reverse = reverse + word.charAt(i);
			if (word.equals(reverse))
				return true;
			else
				return false;
		}
	}
}