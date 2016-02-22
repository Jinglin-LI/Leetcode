/*
Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dis = new int[m][n];                                                  // use int[][] dis to store the longest path from that index
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, DFS(dis, matrix, i, j));                          // return the max number in the dis[][].
            }
        }
        return res;
    }
    private int DFS(int[][] dis, int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (dis[i][j] != 0)                                                           // is visited. If visited, dis[i][j] changed, at least 1.
            return dis[i][j];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < dir.length; k++) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[i][j] < matrix[newI][newJ]) {
                dis[i][j] = Math.max(dis[i][j], DFS(dis, matrix, newI, newJ));        // note the usage of max
            }
        }
        dis[i][j]++;                                                                  // count the path in dis[i][j]
        return dis[i][j];
    }
}
