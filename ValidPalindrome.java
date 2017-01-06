/*
 * problem description:
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 * 
 * */
package practice;

// You can use == to compare, if char is equal
// Since char is a primitive element and you can compare it by using the == operator.

public class ValidPalindrome {

	public static void main(String[] args) {

		String input = "A man, a plan, a canal: P a nam a";

		// input = "01 a 10";
		// input = "a.";
		// input = ",.";
		System.out.println(new ValidPalindrome().isPalindrome(input));
	}

	/*
	 * my version of valid palindrome time complexity O(n/2) space complexity
	 * O(1)
	 */

	// Submission Result: Time Limit Exceeded
	// learning/breaking point: Character toLowerCase is more faster than String
	// toLowerCase. As a result, I got accepted when changed String to Character

	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		} else if (s.length() == 1 || s.length() == 0) {
			return true;
		}
		int start = 0, end = s.length() - 1, result = 0;
		while (start < end) {

			while (!isEngNum(s.charAt(start)) && start < end) {
				start++;
			}
			while (!isEngNum(s.charAt(end)) && start < end) {
				end--;
			}

			result = Character.toLowerCase(s.charAt(start)) ^ Character.toLowerCase(s.charAt(end));
			start++;
			end--;
			if (result > 0) {
				return false;
			}
		}
		return result == 0;
	}

	public boolean isEngNum(char c) {
		// considering the special case that include number inside the string
		// such as "0P"
		return Character.isDigit(c) || Character.isLetter(c);
	}
}
