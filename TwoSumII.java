// Similar to TwoSum.java, except that the input array is already sorted in ascending order. 

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
			int j = BinarySearch (nums, target - nums[i], i + 1);
				if (j != -1) {
				return new int[] { i + 1, j + 1 };
				}	
			}
			throw new IllegalArgumentException ("no such two numbers");
		}

	public int BinarySearch(int[] a, int key, int start) {
		int left = start;
		int right = a.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (key < a[middle]) {
				right = middle - 1; 
			}
			else if (key > a[middle]) {
				left = a[middle] + 1;
			}
			else
				return middle;
		}
//		throw new IllegalArgumentException ("no such two numbers");
		return -1;
	}
}
