/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/
/* 
利用两个dp,我们可以划分为2个区间[0,i]和[i,len-1]，i可以取0~len-1
那么两次买卖的最大利润为：在两个区间的最大利润之和, 的最大利润。
即，从左到右求一遍最大利益（利用最小值），从右到左求一遍最大利益（利用最大值）。最后遍历，在i点时便是左右两个区间都有最大值的情况。
例子：  prices: 2  6  5  2  5  1  2  2  2  8  3
        dp1:    0  4  4  4  4  4  4  4  4  7  7
        dp2:    7  7  7  7  7  7  6  6  6  0  0
        res:    7 11 11 11 11 11 10 10 10  7  7         res = 11
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int res = 0;
        int dp1[] = new int[len];
        int dp2[] = new int[len];
        int min = prices[0];
        int max = prices[len - 1];
        
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp1[i] + dp2[i]);
        }
        return res;
    }
}
