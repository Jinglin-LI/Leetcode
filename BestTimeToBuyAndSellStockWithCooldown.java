/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
/*
Reference: https://segmentfault.com/a/1190000004193861
DP. buy 和 sell 两个一维DP数组。
这道题比较麻烦的是有个cooldown的限制，其实本质也就是买与卖之间的限制。
对于某一天，股票有三种状态: buy, sell, cooldown.
sell与cooldown我们可以合并成一种状态，因为手里最终都没股票，最终需要的结果是sell，即手里股票卖了获得最大利润。
所以我们可以用两个DP数组分别记录当前持股跟未持股的状态。然后根据题目中的限制条件，理清两个DP数组的表达式。

对于当天最终未持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是昨天持股了，今天卖了。
所以我们只要取这两者之间最大值即可，表达式如下：
sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);

对于当天最终持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天还没持股，今天买了股票.
这里是因为cooldown的原因，所以今天买股要追溯到前天的状态。我们只要取这两者之间最大值即可，表达式如下：
buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);

最终我们要求的结果是
sellDp[n - 1] 表示最后一天结束时手里没股票时的累积最大利润
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        if (prices.length >= 2)
            buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            if (i >= 2)
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
