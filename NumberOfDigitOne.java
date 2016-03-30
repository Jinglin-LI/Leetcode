/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
*/
// 归纳法。除去10~19(把100分十份，第二份)，其他的二位数都是有1个‘1’。 Reference: http://www.cnblogs.com/grandyang/p/4629032.html

public class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int a = 1;
        int b = 1;
        while (n > 0) {
            res += (n + 8) / 10 * a + (n % 10 == 1? b : 0);             // 用(x+8)/10来判断一个数是否大于等于2
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return res;
    }
}
