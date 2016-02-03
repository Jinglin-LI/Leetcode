/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
                                                                                    // Note, there is no if (nums[i] > target) break; ! because of the negative target
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[i] + nums[j] + nums[low] + nums[high] < target) {
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        low++;
                    }
                    else if (nums[i] + nums[j] + nums[low] + nums[high] > target) {
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        high--;
                    }
                    else if (nums[i] + nums[j] + nums[low] + nums[high] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
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
        }
        return res;
    }
}
