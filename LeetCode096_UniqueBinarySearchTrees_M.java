package practice;

import java.util.Arrays;

/**
 * problem description: </br>
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n? </br>
 * For example, </br>
 * Given n = 3, there are a total of 5 unique BST's. </br>
 * 
 *  1      3   3   2   1 </br>
 *   \    /   /   / \   \ </br>
 *   3   2   1   1   3   2 </br>
 *   /  /    \            \ </br>
 *  2  1      2            3 </br>
 */

public class LeetCode096_UniqueBinarySearchTrees_M {

	// the most challenge point for dynamic programming
	// is how to find out the formulate of this problem to solve it
	// I should use extra space to recode that what did the fTree calculate
	// before
	// because i want to reduce the time complexity here

	public int numTrees(int n) {
		if (n <= 0) {
			return 1;
		}

		// recode the calculated data
		int table[] = new int[n + 1];
		Arrays.fill(table, 0);
		table[0] = 1;
		table[1] = 1;
		return startFindNum(n, table);
	}

	public int startFindNum(int n, int table[]) {
		if (table[n] != 0) {
			return table[n];
		} else {
			int temp = 0;
			for (int k = 1; k <= n; k++) {
				temp += (startFindNum(k - 1, table) * startFindNum(n - k, table));
			}
			table[n] = temp;
			return temp;
		}
	}

}
