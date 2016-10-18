/**
Given a non-empty array containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Note:
Both the array size and each of the array element will not exceed 100.
Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/
// previous AC because of the limited case.
/*
Use the DP. record the possibility of sum in the index i. For example, dp[3] is true, 
means there is subset which contains the elements whoes sum is 3. 
The second for loop is from target to nums[i]. Because of the case: {1,2,5}. when go forward
Therefore this code is go backwords. dp[i - num] represent the previous sum before adding the current one. 
For example: 		 {1,2,5}
		dp index	0 1 2 3 4
		first dp[]      1 1 0 0 0
		second dp[]     1 1 1 1 0		res is dp[4], false;
*/

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if ((sum % 2) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (Integer num : nums) {
            for (int i = target; i >= num; i--) 
                    dp[i] = dp[i] || dp[i - num];
        }
        return dp[target];
    }
}
