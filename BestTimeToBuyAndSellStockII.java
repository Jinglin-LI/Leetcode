/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int res = 0;
        int i = 0;
        while (i < prices.length - 1) {
            int buy = 0, sell = 0;                                        // 每一次遇到一个升序则存储，所以内部变量
            while (i < prices.length - 1 && prices[i + 1] < prices[i])
                i++;
            buy = i;
            i++;                                                          // 如果有重复的数字，则死循环
            while (i < prices.length && prices[i] > prices[i - 1])        // 考虑最后一个元素如果和倒数第二个是降序
                i++;
            sell = i - 1;
            res = res + prices[sell] - prices[buy];
        }
        return res;
    }
}
