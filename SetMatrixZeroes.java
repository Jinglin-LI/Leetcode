/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flagrow = false, flagcol = false;
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == 0) {
                    if (i == 0)
                        flagcol = true;
                    if (j == 0)
                        flagrow = true;
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; j++)
                    matrix[j][i] = 0;
            }
        }
        
        for (int j = 1; j < row; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 0; i < col; i++)
                    matrix[j][i] = 0;
            }
        }
        
        if (flagrow) {
            for (int i = 0; i < col; i++) 
                matrix[0][i] = 0;
        }
        
        if (flagcol) {
            for (int j = 0; j < row; j++)
                matrix[j][0] = 0;
        }
    }
}
