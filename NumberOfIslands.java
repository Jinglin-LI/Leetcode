/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0)
            return res;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] surround = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    q.add(i * n + j);
                    visited[i][j] = true;
                    res++;
                    while (!q.isEmpty()) {
                        int point = q.poll();
                        int x = point / n;
                        int y = point % n;
                        for (int k = 0; k < surround.length; k++) {
                            int newX = x + surround[k][0];
                            int newY = y + surround[k][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if (grid[newX][newY] == '1' && !visited[newX][newY]) {
                                    q.add(newX * n + newY);
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
