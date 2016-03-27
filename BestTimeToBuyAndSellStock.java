/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int dp[] = new int[prices.length];
        dp[0] = 0;                                                  // 为了防止不合法的array. 比如5,2,1.有合法的升序才更新dp.
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if (prices[i] <= dp[i - 1]) {
                dp[i] = dp[i - 1];
            }
            else {
                int temp = prices[i] - min;
                dp[i] = Math.max(dp[i - 1], temp);
            }
        }
        return dp[prices.length - 1];
    }
}
