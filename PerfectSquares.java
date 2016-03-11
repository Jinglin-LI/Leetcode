/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/
// 注意12 = 4 + 4 + 4 不是12 = 9 + 1 + 1 + 1. 所以不是就近相减。 此题列出来一些数来概括。只有1、2、3、4四种答案。以四的倍数为循环。
// 例如从1算起，结果是1,2,3,1,2,3,4,2,1,2,3,3,2,3,4,1...

public class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) 
            n = n / 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);         
            if (i * i + j * j == n) {
                if (i == 0 || j == 0)                   // Only 2 cases, need 1 to supplment the num or not
                    return 1;
                else
                    return 2;
            }
        }
        return 3;
    }
}
