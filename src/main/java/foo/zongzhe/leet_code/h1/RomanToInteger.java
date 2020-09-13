package main.java.problems.h1;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("MCMXCIV"));
		System.out.println(rti.romanToInt("III"));
		System.out.println(rti.romanToInt("IV"));
		System.out.println(rti.romanToInt("IX"));
		System.out.println(rti.romanToInt("LVIII"));

	}

	/**
	 * Runtime: 15 ms, faster than 38.19% of Java online submissions for Roman to Integer.
	 * Memory Usage: 38.3 MB, less than 55.87% of Java online submissions for Roman to Integer.
	 */

	public int romanToInt(String s) {
		int res = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}

		// Get rid of 4s and 9s
		if (s.indexOf("IV") != -1) {
			res += 4;
			s = s.replaceAll("IV", "");
		} else if (s.indexOf("IX") != -1) {
			res += 9;
			s = s.replaceAll("IX", "");
		}
		// System.out.println(String.format("For 4, res is %d and string is %s", res, s));

		if (s.indexOf("XL") != -1) {
			res += 40;
			s = s.replaceAll("XL", "");
		} else if (s.indexOf("XC") != -1) {
			res += 90;
			s = s.replaceAll("XC", "");
		}
		// System.out.println(String.format("For 40, res is %d and string is %s", res, s));

		if (s.indexOf("CD") != -1) {
			res += 400;
			s = s.replaceAll("CD", "");
		} else if (s.indexOf("CM") != -1) {
			res += 900;
			s = s.replaceAll("CM", "");
		}
		// System.out.println(String.format("For 400, res is %d and string is %s", res, s));

		res += getNum("M", s, 1000);
		res += getNum("D", s, 500);
		res += getNum("C", s, 100);
		res += getNum("L", s, 50);
		res += getNum("X", s, 10);
		res += getNum("V", s, 5);
		res += getNum("I", s, 1);

		return res;
	}

	private int getNum(String pattern, String s, int multi) {
		int patternInd = s.indexOf(pattern);
		if (patternInd != -1) {
			return (s.lastIndexOf(pattern) - patternInd + 1) * multi;
			// s = s.replaceAll("M", "");
		}
		return 0;
	}

}
