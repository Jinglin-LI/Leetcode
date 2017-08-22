/*
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		System.out.println(new RemoveElement().removeElement2(nums, 3));
	}
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val)
				nums[count++] = nums[i];
		}
		return count;
	}
	public int removeElement2(int[] nums, int val) {
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			while (i <= j && nums[i] != val)
				i++;
			while (i <= j && nums[j] == val)
				j--;
			if (i <= j) {
				nums[i] = nums[j];
				nums[j] = val;
				i++;
				j--;
			}
		}
		return i;
	}
}

