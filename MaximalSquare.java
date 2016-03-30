/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
/*
DP. 存储由[i][j]作为右下角，构成的最大的正方形的长度。
[i][j]的上方、左边、左上方，为‘1’时，作为右下角，构成的最大的正方形的长度，加一则为dp[i][j]
然而如果三者不同，即构成最大正方形时候的长度不同，则缺了某个部分，例如：matrix为
          0 1 1                       0 1 1
          1 1 1                       1 1 2
          1 1 1       其dp为：        1 2 2       <- dp[2][2] 
dp[2][2]则取三者dp[1][2]、dp[2][1]、dp[1][1]中的最小值加1.
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
