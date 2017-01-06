/**
  problem description:
  Say you have an array for which the ith element is the price of a given stock on day i.

  If you were only permitted to complete at most one transaction 
  (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
  Example 1:
  Input: [7, 1, 5, 3, 6, 4]
  Output: 5
  
  max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
  Example 2:
  Input: [7, 6, 4, 3, 1]
  Output: 0
  
  In this case, no transaction is done, i.e. max profit = 0.

*/
public class MaxProfit_E {

	public static void main(String[] args) {

		int input[] = new int[] { 7, 3, 5, 3, 6, 4, 1, 2, 5 };

		System.out.println(" ==> " + new MaxProfit_E().maxProfitII(input));

	}

	public int maxProfitII(int[] prices) {
		// using another parameter for the start index and that can reduce the
		// time complexity from O(n^2) to O(n)
		int result = 0;
		if (prices == null || prices.length < 2) {
			return result;
		}
		int start = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (start > prices[i]) {
				start = prices[i];
			}
			result = Math.max(result, prices[i] - start);
		}
		return result;
	}

	public int maxProfit(int[] prices) {
		// using "Mathematical Induction" to solve this problem
		// time complexity O(n^2) Time Limit Exceeded
		// 0,1,2,3 => array index
		// a,b,c,d
		// n=1 => b-a
		// n=2 => b-a c-a c-b
		// n=3 => b-a c-a d-a c-b d-b d-c
		int result = 0;
		if (prices == null || prices.length < 2) {
			return result;
		}
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < i; j++) {
				result = Math.max(result, prices[i] - prices[j]);
			}

		}
		return result;
	}

}