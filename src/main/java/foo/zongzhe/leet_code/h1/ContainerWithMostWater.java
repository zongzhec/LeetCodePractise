package main.java.problems.h1;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		System.out.println(cwmw.maxArea(height));
	}

	/*
	 * Two for loops
	 * Runtime: 787 ms, faster than 5.06% of Java online submissions for Container With Most Water.
	 * Memory Usage: 39.1 MB, less than 98.29% of Java online submissions for Container With Most Water.
	 */
	public int maxArea(int[] height) {
		int maxArea = 0;
		int currentArea = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < height.length; j++) {
				if (height[j] >= height[i]) {
					currentArea = Math.abs(j - i) * height[i];
					// System.out.println("");
					maxArea = Math.max(currentArea, maxArea);
				}
			}
		}
		return maxArea;
	}

}
