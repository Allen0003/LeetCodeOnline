/*
  problem description:

  Given an array and a value, remove all instances of that 
  value in place and return the new length.
  
  Do not allocate extra space for another array, 
  you must do this in place with constant memory.
  
  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
  
  Example:
  Given input array nums = [3,2,2,3], val = 3
  
  Your function should return length = 2, with the first two elements of nums being 2.
  
  Hint:
  
  Try two pointers.
  Did you use the property of "the order of elements can be changed"?
  What happens when the elements to remove are rare?
*/

public class RemoveElement_E {

	public static void main(String[] args) {

		int input[] = new int[] { 3, 2 };
		int val = 0;
		System.out.println(" => " + new RemoveElement_E().removeElement(input, val));

	}

	public int removeElement(int[] nums, int val) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			if (nums[0] == val) {
				return 0;
			}
			return 1;
		}

		int headIndex = 0, tailIndex = nums.length - 1;
		int count = 0; // how many targeted numbers that i find
		int temp = 0;

		while (headIndex <= tailIndex) {
			if (nums[tailIndex] == val) {
				tailIndex--;
				count++;
			} else if (nums[headIndex] == val) {
				count++;
				temp = nums[tailIndex];
				nums[tailIndex] = nums[headIndex];
				nums[headIndex] = temp;
				headIndex++;
				tailIndex--;
			} else {
				headIndex++;
			}
		}
		while (count != 0) {
			nums = Arrays.copyOf(nums, nums.length - 1);
			count--;
		}
		return nums.length;
	}
}