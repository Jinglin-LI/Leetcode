/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
/*
完全参考：http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
题意：用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。最多交易k次，手上最多只能持有一支股票，求最大收益。

分析：特殊动态规划法。传统的动态规划我们会这样想，到第i天时进行j次交易的最大收益，
要么等于到第i-1天时进行j次交易的最大收益（第i天价格低于第i-1天的价格），
要么等于到第i-1天时进行j-1次交易，然后第i天进行一次交易（第i天价格高于第i-1天价格时）。
于是得到动规方程如下（其中diff = prices[i] – prices[i – 1]）：
profit[i][j] = max(profit[i – 1][j], profit[i – 1][j – 1] + diff)
看起来很有道理，但其实不对，为什么不对呢？因为diff是第i天和第i-1天的差额收益，
如果第i-1天当天本身也有交易呢（也就是说第i-1天刚卖出了股票，然后又买入等到第i天再卖出），
那么这两次交易就可以合为一次交易，这样profit[i – 1][j – 1] + diff实际上只进行了j-1次交易，而不是最多可以的j次，这样得到的最大收益就小了。
那么怎样计算第i天进行交易的情况的最大收益，才会避免少计算一次交易呢？
我们用一个局部最优解和全局最有解表示到第i天进行j次的收益，这就是该动态规划的特殊之处。

用local[i][j]表示到达第i天时，最多进行j次交易的局部最优解；
用global[i][j]表示到达第i天时，最多进行j次的全局最优解。它们二者的关系如下（其中diff = prices[i] – prices[i – 1]）：
local[i][j] = max(global[i – 1][j – 1] , local[i – 1][j] + diff)
global[i][j] = max(global[i – 1][j], local[i][j])
local[i][j]和global[i][j]的区别是：local[i][j]意味着在第i天一定有交易（卖出）发生，
当第i天的价格高于第i-1天（即diff > 0）时，
那么可以把这次交易（第i-1天买入第i天卖出）跟第i-1天的交易（卖出）合并为一次交易，即local[i][j]=local[i-1][j]+diff；
当第i天的价格不高于第i-1天（即diff<=0）时，
那么local[i][j]=global[i-1][j-1]+diff，而由于diff<=0，所以可写成local[i][j]=global[i-1][j-1]。
global[i][j]就是我们所求的前i天最多进行k次交易的最大收益，可分为两种情况：
如果第i天没有交易（卖出），那么global[i][j]=global[i-1][j]；如果第i天有交易（卖出），那么global[i][j]=local[i][j]。
*/

/*
http://blog.csdn.net/linhuanmars/article/details/23236995
此解释更清晰一些。规定local[][]是到达i天必须卖出的局部。
global[i][j]容易推导：global[i - 1][j]与local[i][j]最大。为第i-1天卖出和第i天卖出最大值。
local[i][j] 为global[i - 1][j - 1] + (diff > 0? diff : 0)与local[i - 1][j] + diff最大(因为local必须最后一天卖)。
local的解释是，剩一次交易留给第i天。如果diff > 0 了就变成第i天卖出，如果diff < 0 则少一次交易(因为是全局)。
第二个元素是，交易次数不会增加。但是local必须最后一天卖，不管diff正负，都要加上。
*/


public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2)
            return 0;
        int days = prices.length;
        if (k >= days)                                  // 如果k大于prices数组长度，求“交易次数不限”的最大收益。
            return maxProfit2(prices);
        
        int[][] local = new int[days][k + 1];
        int[][] global = new int[days][k + 1];
        
        for (int i = 1; i < days; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[days - 1][k];
    }
    private int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
