package main.java.problems.h1;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse2(-12300));
	}

	/*
	 * Read as string and reverse char one by one.
	 * Runtime: 12 ms, faster than 50.15% of Java online submissions for Reverse Integer.
	 * Memory Usage: 34.7 MB, less than 59.77% of Java online submissions for Reverse Integer.
	 */
	public int reverse(int x) {
		String inputStr = Integer.toString(x, 10);
		System.out.println("String is: " + inputStr);
		String reversedStr = "";
		if (inputStr.charAt(0) == '-') {
			inputStr = inputStr.substring(1);
			reversedStr = "-";
		}
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			reversedStr += inputStr.charAt(i);
		}
		System.out.println("reversed string is: " + reversedStr);
		Long longValue = Long.valueOf(reversedStr);
		if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
			return 0;
		} else {
			return Integer.valueOf(longValue.toString());
		}
	}

	/*
	 * Pure math way
	 * Runtime: 2 ms, faster than 62.28% of Java online submissions for Reverse Integer.
	 * Memory Usage: 32.9 MB, less than 64.07% of Java online submissions for Reverse Integer.
	 */
	public int reverse2(int x) {
		Long longValue = 0L;
		boolean negetive = (x < 0) ? true : false;
		x = (x < 0) ? -x : x;
		while (x > 0) {
			int digit = x % 10;
			longValue = longValue * 10 + digit;
			x = x / 10;
		}
		longValue = (negetive) ? -longValue : longValue;
		if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
			return 0;
		} else {
			return Integer.valueOf(longValue.toString());
		}
	}

}
