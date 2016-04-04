/*
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/
/*
DP. 先将所有位填充Integer.MAX_VALUE, dp[i]为前面某dp[i - coins[j]] (coins[j]是硬币的遍历) + 1. 
用i遍历1~amount, 用j遍历coins
例子：                1 2 3 4 5 6 7 8 9 10 11
                dp: 0 1 1 2 2 1 2 2 3 3  2  3
*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
