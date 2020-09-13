package main.java.problems.h1;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstring l = new LongestSubstring();
		l.lengthOfLongestSubstring("abacdfg");

	}

	public int lengthOfLongestSubstring(String s) {
		System.out.println("parsing str: " + s);
		int longestLen = 0;
		int currentLen = 1;
		// int left = 0;
		int right = 0;
		boolean repeat = false;
		Set<Character> subStrSet = new HashSet<>();

		for (int left = 0; left < s.length(); left++) {
			right = left;
			repeat = false;
			subStrSet.clear();
			subStrSet.add(s.charAt(left));
			currentLen = 1;

			while (!repeat) {
				right = right + 1;
				if (right < s.length()) {
					Character character = s.charAt(right);
					if (subStrSet.contains(character)) {
						repeat = true;						
						break;
					} else {
						currentLen += 1;
						subStrSet.add(character);
					}
				} else {
					break;
				}
			}
			if (currentLen > longestLen) {
				longestLen = currentLen;
				System.out.println("logest substr: " + s.substring(left, right));
			}
		}
		return longestLen;
	}

}
