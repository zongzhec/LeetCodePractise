package main.java.problems.h1;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(12321));
	}

	/*
	 * String conversion is not allowed.
	 * Runtime: 8 ms, faster than 70.05% of Java online submissions for Palindrome Number.
	 * Memory Usage: 34.8 MB, less than 82.01% of Java online submissions for Palindrome Number.
	 */
	public boolean isPalindrome(int x) {
		Long reverse = 0L;
		if (x == 0) {
			return true;
		}
		if (x < 0 || x % 10 == 0) {
			return false;
		}
		long xLong = Long.valueOf(x);

		while (x > 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		if (reverse.equals(xLong)) {
			return true;
		} else {
			return false;
		}

	}

}
