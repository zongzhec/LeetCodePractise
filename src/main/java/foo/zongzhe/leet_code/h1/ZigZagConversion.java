package main.java.problems.h1;

public class ZigZagConversion {

	public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		// zz.mockStr();
		System.out.println(zz.convert("PAYPALISHIRING", 3));
		System.out.println(zz.convert("PAYPALISHIRING", 4));
		System.out.println(zz.convert("AB", 1));

	}

	private void mockStr() {
		String[][] zigIndex = new String[3][5];

		for (int i = 0; i < zigIndex.length; i++) {
			for (int j = 0; j < zigIndex[0].length; j++) {
				zigIndex[i][j] = i + "+" + j;
			}
		}

		for (int i = 0; i < zigIndex.length; i++) {
			for (int j = 0; j < zigIndex[0].length; j++) {
				System.out.print(zigIndex[i][j]);
			}
			System.out.println();
		}

	}

	/*
	 * Use two-dimensional array
	 * 
	 * Time Limit Exceeded on lartge numbers
	 */
	public String convert(String s, int numRows) {
		String res = "";
		if (s == null || s.length() == 0) {
			return "";
		}

		if (numRows == 1) {
			return s;
		}

		char[][] zigIndex = new char[numRows][s.length() / 2 + 1];

		// initialize
		for (int i = 0; i < zigIndex.length; i++) {
			for (int j = 0; j < zigIndex[0].length; j++) {
				zigIndex[i][j] = '#';
			}
		}

		boolean goDown = true;
		int row = 0;
		int col = 0;
		for (int i = 0; i < s.length(); i++) {
			zigIndex[row][col] = s.charAt(i);

			if (goDown) {
				row++;
			} else {
				row--;
				col++;
			}

			if (row == numRows - 1) {
				goDown = false;
			} else if (row == 0) {
				goDown = true;
			}

		}

		// for (int i = 0; i < zigIndex.length; i++) {
		// for (int j = 0; j < zigIndex[0].length; j++) {
		// System.out.print(zigIndex[i][j]);
		// }
		// System.out.println();
		// }

		for (int i = 0; i < zigIndex.length; i++) {
			for (int j = 0; j < zigIndex[0].length; j++) {
				res += zigIndex[i][j];
			}

		}

		res = res.replaceAll("#", "");
		// System.out.println("res: " + res);

		return res;

	}

}
