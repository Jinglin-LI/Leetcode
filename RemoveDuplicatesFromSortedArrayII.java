/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                nums[count] = nums[i];
                hm.put(nums[i], 1);
                count++;
            }
            else if (hm.containsKey(nums[i]) && hm.get(nums[i]) == 1) {
                nums[count] = nums[i];
                hm.put(nums[i], 2);
                count++;
            }
        }
        return count;
    }
}
