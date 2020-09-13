package main.java.problems.h1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution1 {
		// Brute Force
		public int[] twoSum(int[] nums, int target) {
			int[] res = new int[2];
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						res[0] = i;
						res[1] = j;
					}
				}
			}
			return res;
		}
	}

	class Solution2 {
		// Hash table
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> store = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				store.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				int gap = target - nums[i];
				if (store.containsKey(gap) && store.get(gap) != i) {
					return new int[] { i, store.get(target - nums[i]) };
				}
			}
			return null;
		}
	}

	class Solution3 {
		// Hash table
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> store = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (store.containsKey(target - nums[i])) {
					return new int[] { store.get(target - nums[i]), i };
				}
				store.put(nums[i], i);
			}
			return null;
		}
	}

}
