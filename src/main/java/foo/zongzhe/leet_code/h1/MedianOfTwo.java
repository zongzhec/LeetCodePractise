package main.java.problems.h1;

public class MedianOfTwo {

	public static void main(String[] args) {
		MedianOfTwo mot = new MedianOfTwo();
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4 };
		System.out.println(mot.findMedianSortedArrays(nums1, nums2));
		int[] nums3 = { 1, 3 };
		int[] nums4 = { 2 };
		System.out.println(mot.findMedianSortedArrays(nums3, nums4));
		int[] nums5 = { 2 };
		int[] nums6 = {};
		System.out.println(mot.findMedianSortedArrays(nums5, nums6));
		int[] nums7 = { 100001 };
		int[] nums8 = { 100000 };
		System.out.println(mot.findMedianSortedArrays(nums7, nums8));

	}

	/**
	 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.
	 * Memory Usage: 46.1 MB, less than 94.12% of Java online submissions for Median of Two Sorted Arrays.
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
			return getMedianValue(nums2);
		}
		if (nums2.length == 0) {
			return getMedianValue(nums1);
		}
		// Merging sort first
		int mergeLength = nums1.length + nums2.length;
		int[] mergedNum = new int[mergeLength];
		int num1Index = 0;
		int num2Index = 0;
		for (int i = 0; i <= (int) (mergeLength / 2); i++) {
			if (num1Index == nums1.length) {
				mergedNum[i] = nums2[num2Index];
				num2Index++;
			} else if (num2Index == nums2.length) {
				mergedNum[i] = nums1[num1Index];
				num1Index++;
			} else if (nums1[num1Index] <= nums2[num2Index]) {
				mergedNum[i] = nums1[num1Index];
				num1Index++;
			} else {
				mergedNum[i] = nums2[num2Index];
				num2Index++;
			}

		}

		// ArrayUtil.printArray(mergedNum);
		return getMedianValue(mergedNum);

	}

	public double getMedianValue(int[] mergedNum) {
		int mergeLength = mergedNum.length;
		int median = (int) mergeLength / 2;
		if (mergeLength % 2 == 0) {
			return (double) (mergedNum[median] + mergedNum[median - 1]) / 2;
		} else {
			return mergedNum[median];
		}
	}

}
