package One2Twenty;

public class L009_E {
	// O(n)
	public boolean isPalindrome_me(int x) {
		String temp = String.valueOf(x);
		if (temp.length() < 2) {
			return true;
		}
		int start = 0, end = temp.length() - 1;
		while (start < end) {
			if (temp.charAt(start) != temp.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// O(log10n)
	public boolean isPalindrome(int x) {
		// Special cases:
		// As discussed above, when x < 0, x is not a palindrome.
		// Also if the last digit of the number is 0, in order to be a
		// palindrome,
		// the first digit of the number also needs to be 0.
		// Only 0 satisfy this property.
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		// When the length is an odd number, we can get rid of the middle digit
		// by revertedNumber/10
		// For example when the input is 12321, at the end of the while loop we
		// get x = 12, revertedNumber = 123,
		// since the middle digit doesn't matter in palidrome(it will always
		// equal to itself), we can simply get rid of it.
		return x == revertedNumber || x == revertedNumber / 10;
	}

}
