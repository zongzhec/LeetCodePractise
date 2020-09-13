package main.java.problems.h1;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		String[] strList = { "aa", "aa", "ab", "aab", "mississippi", "", "", "" };
		String[] pattern = { "a", "a*", ".*", "c*a*b", "mis*is*p*.", "c*", "c*c*", "." };
		for (int i = 0; i < strList.length; i++) {
			System.out.println(rem.isMatch(strList[i], pattern[i]));
		}
		System.out.println("");

	}

	/*
	 * A trick way using java in-built function.
	 * Runtime: 84 ms, faster than 7.08% of Java online submissions for Regular Expression Matching.
	 * Memory Usage: 38.2 MB, less than 67.19% of Java online submissions for Regular Expression Matching.
	 */
	public boolean isMatch(String s, String p) {
		System.out.println("String is: " + s + ", pattern is: " + p);
		if (s.isEmpty()) {
			if (p.isEmpty()) {
				return true;
			} else if (p.length() % 2 == 1) {
				return false;
			} else {
				// Check if p like "c*c*"
				for (int i = 1; i < p.length(); i = i + 2) {
					if (p.charAt(i) != '*') {
						return false;
					}
				}
				return true;
			}
		}
		s = s.replaceFirst(p, "");
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
