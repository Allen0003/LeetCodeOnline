package practice;

import java.util.HashMap;

/**
 * problem description: Write a program to find the n-th ugly number. </br>
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. </br>
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers. </br>
 * Note that 1 is typically treated as an ugly number. </br>
 */

public class LeetCode263_UglyNumber_E {

	// because the new ugly number must be created by a smaller ugly number
	// imagine the ugly number in row are 1 2 3 4 5 6 8
	// min(1*2 , 1*3 , 1*5) then moving the index of 2 to next
	// second => min(2*2 , 1*3 , 1*5) then moving the index of 3 to next

	public int nthUglyNumber(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int p2 = 1, p3 = 1, p5 = 1;
		for (int i = 2; i <= n; i++) {

			dp[i] = Math.min(2 * dp[p2], Math.min(3 * dp[p3], 5 * dp[p5]));

			if (dp[i] == 2 * dp[p2]) {
				p2++;
			}
			if (dp[i] == 3 * dp[p3]) {
				p3++;
			}
			if (dp[i] == 5 * dp[p5]) {
				p5++;
			}
		}
		return dp[n];
	}

	// finding the n-th ugly number
	// naive method to solve the problem. However, it will over the time limit
	public int nthUglyNumber1(int n) {
		HashMap<Integer, Boolean> answerTable = new HashMap<Integer, Boolean>();
		answerTable.put(1, true);
		int count = 0;
		int i = 1;
		while (count < n) {
			answerTable.put(i, isUglyNumber(i, answerTable));
			if (answerTable.get(i)) {
				count++;
			}
			i++;
		}
		return (i - 1);
	}

	public static boolean isUglyNumber(int input, HashMap<Integer, Boolean> answerTable) {
		if (input == 1 || input == 0) {
			return true;
		}
		if (answerTable.get(input) != null) {
			return answerTable.get(input);
		}
		int target[] = new int[] { 2, 3, 5 };
		for (int i = 0; i < target.length; i++) {
			if ((input % target[i]) == 0) {
				int temp = input / target[i];
				return isUglyNumber(temp, answerTable);
			}
		}
		return false;
	}

}
