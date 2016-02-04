/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[mid][0] > target)
                high = mid - 1;
            else if (matrix[mid][0] < target) {
                low = mid + 1;                                         // Do not afraid that the low row does not include target
            }
            else
                return true;
        }
        int targetrow = high;
        if (targetrow < 0)
            return false;
            
        int start = 0, end = matrix[0].length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (matrix[targetrow][middle] > target)
                end = middle - 1;
            else if (matrix[targetrow][middle] < target)
                start = middle + 1;
            else
                return true;
        }
        return false;
    }
}
