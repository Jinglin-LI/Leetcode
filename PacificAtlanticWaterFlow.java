/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:
Given the following 5x5 matrix:
  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic
Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/
// reference : https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || 
				matrix[0].length == 0)
			return res;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] p = new boolean[m][n];          // 能达到Pacific的点
		boolean[][] a = new boolean[m][n];          // 能达到Atlantic的点
		Queue<int[]> pq = new LinkedList<>();
		Queue<int[]> aq = new LinkedList<>();
		for (int i = 0; i < m; i++) {               // 初始化，最上和最下行
			pq.add(new int[]{i, 0});
			aq.add(new int[]{i, n - 1});
			p[i][0] = true;
			a[i][n - 1] = true;
		}
		for (int j = 0; j < n; j++) {               // 初始化，最左和最右列
			pq.add(new int[]{0, j});
			aq.add(new int[]{m - 1, j});
			p[0][j] = true;
			a[m - 1][j] = true;
		}
		bfs(matrix, pq, p);
		bfs(matrix, aq, a);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (p[i][j] && a[i][j])
					res.add(new int[]{i, j});
			}
		}
		return res;
	}
	
	int[][] dir = {{-1,0},{1,0},{0,-1},{0, 1}};
	public void bfs(int[][] matrix, Queue<int[]> q, boolean[][] visited) {
		int m = matrix.length;
		int n = matrix[0].length;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if (x < 0 || x >= m || y < 0 || y >= n ||
						visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
					continue;
				}
				visited[x][y] = true;
				q.add(new int[]{x, y});
			}
		}
	}
}
