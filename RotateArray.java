/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		new RotateArray().rotate2(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		for (int i = 0; i < k; i++) {                           // n2
			int temp = nums[len - 1];
			for (int j = len - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = temp;
		}
	}
	public void rotate2(int[] nums, int k) {                    // 1234567 -> 7654321 -> 5671234 即前几个后几个再reverse回去
		int len = nums.length;
		k = k % len;
		reverse (nums, 0, len - 1);
		reverse (nums, 0, k - 1);
		reverse (nums, k, len - 1);
	}
	public void reverse (int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
