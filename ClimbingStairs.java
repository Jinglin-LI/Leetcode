/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        int p = 1;
        int q = 1;
        int temp = 1;
        
        for (int i = 2; i <= n; i++) {
            temp = q;
            q = p + q;
            p = temp;
        }
        return q;
    }
}
