/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
*/

public class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            if (nums[i] == 1)
                count1++;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < count0; i++)
            res[i] = 0;
        for (int i = count0; i < (count0 + count1); i++)
            res[i] = 1;
        for (int i = (count0 + count1); i < nums.length; i++)
            res[i] = 2;
            
        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
    
    public void sortColors2(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int startIndex = 0, endIndex = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == 0 && i != startIndex) {
				int temp = nums[startIndex];
				nums[startIndex++] = nums[i];
				nums[i] = temp;
			}
			else if (nums[i] == 2 && i < endIndex) {
				int temp = nums[i];
				nums[i] = nums[endIndex];
				nums[endIndex--] = temp;
			}
			else {
				i++;
			}
		}
	}
}
