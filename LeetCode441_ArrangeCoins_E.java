/**
problem description: 

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
?
? ?
? ?

Because the 3rd row is incomplete, we return 2.

*/



/**
 * cannot come up with it myself
 * 
 * my solution is O(n) or recursive - spend too much time
 * 
 * the liner solution is using the math formulate to solve it.
 * 
 * The point for this question is that you need to think about using "math" to solve it
 */

public class ArrangeCoins_E {

	public static void main(String[] args) {

		System.out.println(new ArrangeCoins_E().arrangeCoins(3));

	}

	public int arrangeCoins(int n) {

		// if (n == 1 || n == 2) {
		// return 1;
		// }
		//
		// if (n == 3) {
		// return 2;
		// }
		//
		// int temp = 0;
		// for (int i = 1; i < n; i++) {
		// temp += i;
		// if (temp > n) {
		// return i - 1;
		// }
		// }
		// return 0;
		return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}

}