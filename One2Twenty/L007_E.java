package One2Twenty;

public class L007_E {
	public static void main(String[] args) {
		System.out.println(new L007_E().reverse(1563847412));
	}

	public int reverse(int x) {
		if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
			return 0;
		}
		int result = 0, index = 1;
		for (int i = 0; i < String.valueOf(Math.abs(x)).length() - 1; i++) {
			index = index * 10;
		}
		for (int i = String.valueOf(Math.abs(x)).length() - 1; i >= 0; i--) {
			int temp = Integer.valueOf(String.valueOf(String.valueOf(Math.abs(x)).charAt(i)));
			if (!this.isOverflowMul(index, temp)) {
				if (!isOverflowAdd(result, index * temp)) {
					result += index * temp;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
			index = index / 10;
		}
		return x > 0 ? result : result * -1;
	}

	public boolean isOverflowMul(int x, int y) {
		long test = (long) x * y;
		return test > Integer.MAX_VALUE || test < Integer.MIN_VALUE;
	}

	public boolean isOverflowAdd(int x, int y) {
		long test = (long) x + y;
		return test > Integer.MAX_VALUE || test < Integer.MIN_VALUE;
	}

}
