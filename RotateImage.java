/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix[0].length - 1;
        for (int i = 0; i < (N + 1) / 2; i++) {
            for (int j = i; j < N - i; j++) {
                int temp = matrix[j][N - i];
                matrix[j][N - i] = matrix[i][j];
                matrix[i][j] = matrix[N - j][i];
                matrix[N - j][i] = matrix[N - i][N - j];
                matrix[N - i][N - j] = temp;
            }
        }
    }
}
