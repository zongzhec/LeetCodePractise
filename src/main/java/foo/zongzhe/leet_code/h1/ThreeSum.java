package main.java.problems.h1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		Map<Integer, Integer> numCount = new HashMap<>();
		List<Integer> numList = new ArrayList<>();

		// Insert values
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i];
			int count = (numCount.containsKey(value)) ? numCount.get(value) : 0;
			numList.add(value);
			numCount.put(value, count + 1);
		}
		
		// Sort
		Collections.sort(numList);
		
		// Search
		for (int i = 0; i < numList.size() - 2; i++) {
			int value1 = numList.get(i);
			if (value1 > 0) {
				break;
			}
			for (int j = i+1 ; j < nums.length - 1; j++) {
				int value2 = numList.get(j);
				
				int value3 = 0 - value1-value2;
				if (numCount.containsKey(value3) && ((value3 != value1 && value3 != value2)||(value3 == value1 && value3 == value2))) {
					
				}
				
			}
		}

		return res;
	}

}
