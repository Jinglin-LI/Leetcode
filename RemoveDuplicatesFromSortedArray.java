/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    
    // two pointers
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
    
    /**************************************************************************************/
    
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);                                    // we can use HashSet instead
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
