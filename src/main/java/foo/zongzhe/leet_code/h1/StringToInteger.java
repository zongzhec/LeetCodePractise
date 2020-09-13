package main.java.problems.h1;

public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.myAtoi("  0000000000012345678"));

	}

	/*
	 * Runtime: 20 ms, faster than 11.82% of Java online submissions for String to Integer (atoi).
	 * Memory Usage: 35.9 MB, less than 95.34% of Java online submissions for String to Integer (atoi).
	 */
	public int myAtoi(String str) {
		// TODO: clean method
		Long longValue = 0L;
		boolean negetive = false;
		if (str == null) {
			return 0;
		}
		str = str.replaceAll("^ *", "");
		if (str.length() == 0) {
			return 0;
		}
		int startIndex = 0;
		switch (str.charAt(0)) {
		case '+':
			startIndex = 1;
			str = str.substring(1).replaceAll("^0*", "");
			break;
		case '-':
			negetive = true;
			str = str.substring(1).replaceAll("^0*", "");
			startIndex = 1;
			break;
		default:
			str = str.replaceAll("^0*", "");
			break;
		}
		System.out.println("String without sign: " + str);
		int endIndex = Math.min(str.length(), 11); // 11 is the max digit for integer with sign
		str = str.substring(0, endIndex);

		if (str.length() == 0) {
			return 0;
		}

		for (int i = 0; i < str.length(); i++) {
			try {
				long digit = Long.parseLong(str.substring(i, i + 1));
				longValue = longValue * 10 + digit;
			} catch (Exception e) {
				break;
			}
		}

		longValue = (negetive) ? -longValue : longValue;

		if (longValue > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (longValue < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return Integer.valueOf(longValue.toString());
		}
	}

}
