package main.java.problems.h1;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(1994));

	}

	/*
	 * Do as Romans do.
	 * Runtime: 50 ms, faster than 5.53% of Java online submissions for Integer to Roman.
	 * Memory Usage: 38.8 MB, less than 55.89% of Java online submissions for Integer to Roman.
	 */
	public String intToRoman(int num) {
		String out = "";
		int thousand = num / 1000;
		int hundred = (num % 1000) / 100;
		int teen = (num % 100) / 10;
		int single = num % 10;

		out += getStr(thousand, "M", "", "");
		out += getStr(hundred, "C", "D", "M");
		out += getStr(teen, "X", "L", "C");
		out += getStr(single, "I", "V", "X");
		return out;
	}

	private String getStr(int num, String string, String five, String ten) {
		String res = "";
		while (num > 0) {
			res += string;
			num--;
		}
		// System.out.println("initial res is:" + res);

		String nineAppearance = getStrConcat(string, 9);
		res = res.replaceFirst(nineAppearance, string + ten);
		String fiveAppearance = getStrConcat(string, 5);
		res = res.replaceFirst(fiveAppearance, five);
		String fourAppearance = getStrConcat(string, 4);
		res = res.replace(fourAppearance, string + five);
		// System.out.println("replaced res is:" + res);
		return res;
	}

	private String getStrConcat(String string, int i) {
		String str = "";
		while (i > 0) {
			str += string;
			i--;
		}
		// System.out.println("getStrConcat: " + str);
		return str;
	}

}
