/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class Solution {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hs.remove(nums[i - k - 1]);             // hashSet.remove
            }
            if (!hs.add(nums[i])) {                     // add to hashSet if there is no duplicates. !hs.add() 意味着存在duplicate
                return true;
            }
        }
        return false;
    }
    
    /********************************************************************/
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (i - hm.get(nums[i]) <= k)
                    return true;
            }
            hm.put(nums[i], i);                       // although maynot less than k, the new index of the same key could be updated.                 
        }
        return false;
    }
}
