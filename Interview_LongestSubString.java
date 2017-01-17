package temp;

import java.util.Arrays;

public class temp {
	public String findLongestSubString(String input) {

		int start = 0, end = 0, max_length = 0;
		String temp_String = "", currentIndex = "", targetString = "";

		String[] compare = input.split("");
		Arrays.sort(compare);

		for (int i = 0; i < compare.length; i++) {
			temp_String = "";
			if (!compare[i].equals(currentIndex)) {
				start = i;
				currentIndex = compare[i];
			} else if (!compare[i].equals("") && compare[i].equals(currentIndex)) {
				end = i + 1;
				if ((end - start) > max_length) {
					for (int j = start; j < end; j++) {
						temp_String += compare[j];
					}
					max_length = temp_String.length();
					targetString = temp_String;
				}
			}
		}
		return targetString;
	}

	public static void main(String[] args) {

		System.out.println(new temp().findLongestSubString("aab1baaccaa"));

	}

}
