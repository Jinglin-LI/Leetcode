/*
Given an array of integers, 
find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t
and the difference between i and j is at most k.
*/
// In the case of [-1,2147483647], overflow（Using Int）. Therefore Int convert to Long. 利用TreeSet存储k个数字，i >= k 时删除前面的。
// floor找TreeSet中小于某一个数的最大值；ceiling找TreeSet中大于某一个数的最小值。

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            if (ts.floor(num) != null && num - ts.floor(num) <= t ||
                ts.ceiling(num) != null && ts.ceiling(num) - num <= t)
                return true;
            ts.add(num);
            if (i >= k)
                ts.remove((long)nums[i - k]);
        }
        return false;
    }
}
