/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
// 排序复杂度不止O(n).用HashSet存储每一个元素，对某一个元素，寻找其加一和减一存不存在，同时remove掉此元素。

public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0)
            return res;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])) {
                int count = 1;
                hs.remove(nums[i]);
            
                int low = nums[i] - 1;
                while (hs.contains(low)) {
                    hs.remove(low);
                    count++;
                    low--;
                }
                
                int high = nums[i] + 1;
                while (hs.contains(high)) {
                    hs.remove(high);
                    count++;
                    high++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
