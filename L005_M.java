package practice;

public class L005_M {
	public static void main(String[] args) {
		System.out.println(new L005_M().longestPalindrome("aaa"));
	}

	private int lo, maxLen;

	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			extendPalindrome(s, i, i);
			// assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1);
			// assume even length.
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		// find two indexes
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}

	// brute force
	// Time Limit Exceeded O(n^3)
	public String longestPalindrome_(String s) {
		if (s.length() < 2) {
			return s;
		}
		boolean isFind = false;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > i; j--) {
				isFind = false;
				if (s.charAt(i) == s.charAt(j)) {
					isFind = true;
					int start = i, end = j;
					while (start <= end) {
						if (s.charAt(start) != s.charAt(end)) {
							isFind = false;
						}
						start++;
						end--;
					}
					if (isFind) {
						if (result.length() <= (j - i)) {
							result = s.substring(i, j + 1);
						}
					}
				}
			}
		}
		return result.equals("") ? s.substring(0, 1) : result;
	}
}
