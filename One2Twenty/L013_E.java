package One2Twenty;

public class L013_E {

	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length();) {
			boolean isTwice = false;
			if (s.length() - i >= 2) {
				if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
					result += 900;
					isTwice = true;
				} else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
					result += 400;
					isTwice = true;
				} else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
					result += 90;
					isTwice = true;
				} else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
					result += 40;
					isTwice = true;
				} else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
					result += 9;
					isTwice = true;
				} else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
					result += 4;
					isTwice = true;
				}
			}
			if (!isTwice) {
				if (s.charAt(i) == 'M') {
					result += 1000;
				} else if (s.charAt(i) == 'D') {
					result += 500;
				} else if (s.charAt(i) == 'C') {
					result += 100;
				} else if (s.charAt(i) == 'L') {
					result += 50;
				} else if (s.charAt(i) == 'X') {
					result += 10;
				} else if (s.charAt(i) == 'V') {
					result += 5;
				} else if (s.charAt(i) == 'I') {
					result += 1;
				}
			}
			i++;
			if (isTwice) {
				i++;
			}
		}
		return result;
	}
}
