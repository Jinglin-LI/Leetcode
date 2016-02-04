/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int number = 1;
        int len = n - 1;
     
        for (int i = 0; i <= (len + 1) / 2; i++) {
        
            if (i == len - i) {                          // Delete this loop doesn't make difference. The last number or when n == 1. 
                res[i][i] = number;
                return res;
            }
            
            int k = 0, j = 0;
            for (k = i; k <= len - i; k++) {
                res[i][k] = number;
                number++;
            }
            for (j = i + 1; j <= len - i; j++) {
                res[j][len - i] = number;
                number++;
            }
            for (k = k - 2; k >= i; k--) {                // Note the "k++" previously, therefore k = k - 2
                res[len - i][k] = number;
                number++;
            }
            for (j = j - 2; j >= i + 1; j--) {
                res[j][i] = number;
                number++;
            }
        }
        return res;
    }
}
