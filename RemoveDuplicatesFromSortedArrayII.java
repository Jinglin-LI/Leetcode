/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = {1,1,1, 2,2,2,3};
		System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
		System.out.println(nums[0] + ", " + nums[1] + ", " + nums[2] + ", " + nums[3] + ", " + nums[4]+ ", " + nums[5]);
	}
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length <= 2)
			return nums.length;
		int count = 1, size = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[count - 1]) {
				size = 1;
				nums[count] = nums[i];
				count++;
			}
			else if (nums[i] == nums[count - 1] && size == 1) {
				nums[count] = nums[i];
				count++;
				size++;
			}
			else if (nums[i] == nums[count - 1] && size == 2) {
				continue;
			}
		}
		return count;
	}
}

