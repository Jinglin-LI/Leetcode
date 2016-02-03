public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int abs = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) 
                    return sum;
                if (abs > Math.abs(sum - target)) {
                    abs = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target) {
                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    low++;
                }
                if (sum > target) {
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    high--;
                }
            }
        }
        return res;
    }
}
