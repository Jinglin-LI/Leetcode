/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
	
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] < - nums[i]) {
                    while (low < high && nums[low] == nums[low + 1])            // Note: ignore the duplicates to avoid TLE
                        low++;
                    low++;
                }
                else if (nums[low] + nums[high] > - nums[i]) {
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    high--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    if (!res.contains(list))                                    // Note the usage of list.contains. Can delete this code because the duplicates have been ignored.
                        res.add(list);
                        
                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    low++;
                    
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    high--;
                }
            }
        }
        return res;
    }
}
