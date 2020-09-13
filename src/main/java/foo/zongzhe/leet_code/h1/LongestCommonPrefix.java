package main.java.problems.h1;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs1 = { "flower", "flow", "flight" };
		System.out.println("Test 1 is: " + lcp.longestCommonPrefix(strs1));
		String[] strs2 = { "flower", "fl", "flight" };
		System.out.println("Test 1 is: " + lcp.longestCommonPrefix(strs2));
		String[] strs3 = { "flower", "flow", "floght" };
		System.out.println("Test 1 is: " + lcp.longestCommonPrefix(strs3));
		String[] strs4 = { "flower", "f", "floght" };
		System.out.println("Test 1 is: " + lcp.longestCommonPrefix(strs4));
		String[] strs5 = { "dog", "racecar", "car" };
		System.out.println("Test 1 is: " + lcp.longestCommonPrefix(strs5));

	}

	public String longestCommonPrefix2(String[] strs) {
		// TODO: implement
		return "";
	}

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
	 * Memory Usage: 35.5 MB, less than 99.88% of Java online submissions for Longest Common Prefix.
	 */

	public String longestCommonPrefix(String[] strs) {
		// special case check
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		// record length of str and find the min
		int minLen = strs[0].length();
		int minLenInd = 0;
		for (int i = 0; i < strs.length; i++) {
			int len = strs[i].length();
			// special check
			if (len == 0) {
				return "";
			} else if (len < minLen) {
				minLen = len;
				minLenInd = i;
			}
		}

		// use half-divide way to get the common prefix
		int left = 0;
		int right = minLen;
		int mid = (left + right + 1) / 2;
		String strToCheck = strs[minLenInd];
		while (mid < right) {
			if (containsCommonPreFix(strs, strToCheck.substring(0, mid))) {
				left = mid;
			} else {
				right = mid - 1;
			}
			mid = (left + right + 1) / 2;
			System.out.println(String.format("left is %d, right is %d, and mid is %d", left, right, mid));
		}

		// TODO: merge this special case handling into above logic
		if (containsCommonPreFix(strs, strToCheck.substring(0, mid))) {
			return strToCheck.substring(0, mid);
		} else {
			return strToCheck.substring(0, mid - 1);
		}

	}

	private boolean containsCommonPreFix(String[] strs, String prefix) {
		for (String string : strs) {
			if (!string.startsWith(prefix)) {
				return false;
			}
		}
		return true;
	}

}
