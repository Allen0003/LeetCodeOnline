/**
problem description:
Implement atoi to convert a string to an integer.
reference: https://leetcode.com/problems/string-to-integer-atoi/
*/
/**
 * some issues must be avoided </br>
 * 1. Int overflow </br>
 * 2. leading character and mid character is not a number, including black space
 * </br>
 * 3. leading character is minus sign
 * 
 */

public class MyAtoi_E {
	public static void main(String[] args) {
		String temp = " b11228552307";
		System.out.println(new MyAtoi_E().myAtoi(temp));
	}

	public int myAtoi(String str) {
		long result = 0;
		String[] temp = str.trim().split("");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].matches("(\\d+)")) {
				if (ctoI(temp[0]) != -1) {
					result = result * 10;
					result += ctoI(temp[i]);
					if (result > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				} else {
					result = result * 10;
					result -= ctoI(temp[i]);
					if (result < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}
			} else if (i != 0 || !temp[i].matches("(-|\\+)")) {
				break;
			}
		}
		return (int) result;
	}

	private int ctoI(String input) {
		switch (input) {
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "-":
			return -1;
		default:
			return 0;
		}
	}
}
