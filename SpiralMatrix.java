/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = -1;
        while (true) {
            for (int i = 0; i < n; i++) {
                res.add(matrix[row][++col]);                            // m and n are scale (range), row and col are indexes.
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                res.add(matrix[++row][col]);
            }
            if (--n == 0) break;
            for (int i = 0; i < n; i++) {
                res.add(matrix[row][--col]);
            }
            if (--m == 0) break;
            for (int i = 0; i < m; i++) {
                res.add(matrix[--row][col]);
            }
            if (--n == 0) break;
        }
        return res;
    }
}
