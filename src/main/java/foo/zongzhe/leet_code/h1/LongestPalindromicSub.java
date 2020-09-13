package main.java.problems.h1;

import foo.zongzhe.leetcode.utils.StringUtil;

public class LongestPalindromicSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSub lps = new LongestPalindromicSub();
		String string = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
		long startTime = System.currentTimeMillis();
		System.out.println("Test 14: " + lps.longestPalindrome2(string));
		long endTime = System.currentTimeMillis();
		System.out.println("Time is: " + (endTime - startTime));
		System.out.println("Test 5: " + lps.longestPalindrome2("ac"));
		System.out.println("Test 1: " + lps.longestPalindrome2("cbcdcbedcbc"));
		System.out.println("Test 1: " + lps.longestPalindrome2("cbcdcbedcbc"));
		System.out.println("Test 1: " + lps.longestPalindrome2("babad"));
		System.out.println("Test 2: " + lps.longestPalindrome2("cbbd"));
		System.out.println("Test 3: " + lps.longestPalindrome2("aacdefcaa"));

	}

	/**
	 * Reverse string and compare the char one by one. TODO: Time Limit Exceeded.
	 * Case input:
	 * "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
	 * 
	 */
	public String longestPalindrome(String s) {
		String longestSub = "";
		String reversStr = StringUtil.reverseString(s);

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < reversStr.length(); j++) {
				if (s.charAt(i) == reversStr.charAt(j)) {
					// the starting point of being same.
					int k = 1;
					while (i + k < s.length() && j + k < s.length() && s.charAt(i + k) == reversStr.charAt(j + k)) {
						k++;
					}
					String longStrCandidate = s.substring(i, i + k);
					if (StringUtil.isPalindromic(longStrCandidate)) {
						longestSub = (longStrCandidate.length() > longestSub.length()) ? longStrCandidate : longestSub;
					}
					// System.out.println("Longstr: " + longStr);
				}
			}
		}
		return longestSub;
	}

	/**
	 * Manacher's algorithm Runtime: 612 ms, faster than 8.35% Memory Usage: 37.7
	 * MB, less than 77.95%
	 */
	public String longestPalindrome2(String s) {
		if (s.length() <= 1)
			return s;
		String longestSub = "" + s.charAt(0);
		String expendedStr = StringUtil.insertWithChar(s, "#");

		for (int i = 1; i < expendedStr.length() - 1; i++) {
			int j = 1;
			while (i - j >= 0 && i + j < expendedStr.length()
					&& expendedStr.charAt(i - j) == expendedStr.charAt(i + j)) {
				j++;
			}
			j--;
			// System.out.println("i=" + i + ",j=" + j);
			String longStrCandidate = expendedStr.substring(i - j, i + j + 1).replaceAll("#", "");
			// System.out.println("longStrCandidate: " + longStrCandidate);
			longestSub = (longStrCandidate.length() > longestSub.length()) ? longStrCandidate : longestSub;
		}
		return longestSub;
	}

}
