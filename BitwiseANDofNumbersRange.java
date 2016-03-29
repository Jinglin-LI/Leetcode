/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
For example, given the range [5, 7], you should return 4.
*/
// 把m与n都向右移动，第一次遇到一样的时候就返回。但是要用offset记当时是在哪个位置为1的。

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != 0 && n != 0) {
            if (m == n)
                return m << offset;
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return 0;
    }
}
