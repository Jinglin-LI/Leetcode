/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    
    // DFS. 把boundary的'O'通过DFS（与boundary的‘O’相连的‘O’）都改成‘~’。剩下的‘O’就应该改成‘X’就对了。
    public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {               // 这两个for loop, 把boundary的‘O’找出来DFS
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][n - 1] == 'O') {
				dfs(board, i, n - 1);
			}
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				dfs(board, 0, j);
			}
			if (board[m - 1][j] == 'O') {
				dfs(board, m - 1, j);
			}
		}
		for (int i = 0; i < m; i++) {               // 这个for loop 把boundary的‘O’改回来，其他的‘O’变成‘X’
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				else if (board[i][j] == '~') {
					board[i][j] = 'O';
				}
			}
		}
	}
	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return;
		if (board[i][j] == 'O')
			board[i][j] = '~';                       // 把通过boundary的‘O’能通到的‘O’都改成‘~’来标记
		if (i > 1 && board[i - 1][j] == 'O')	         // 把visited过的都改成了‘~’，即提供了判断是否visited.
			dfs(board, i - 1, j);
		if (i < board.length - 2 && board[i + 1][j] == 'O')
			dfs(board, i + 1, j);
		if (j > 1 && board[i][j - 1] == 'O')
			dfs(board, i, j - 1);
		if (j < board[i].length - 2 && board[i][j + 1] == 'O')
			dfs(board, i, j + 1);
	}
    
    /***************************************************************************************/
    
    // BFS
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
		int n = board[0].length;
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = '~';
				q.offer(new Point(i, 0));
			}
			if (board[i][n - 1] == 'O') {
				board[i][n - 1] = '~';
				q.offer(new Point(i, n - 1));
			}
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				board[0][j] = '~';
				q.offer(new Point(0, j));
			}
			if (board[m - 1][j] == 'O') {
				board[m - 1][j] = '~';
				q.offer(new Point(m - 1, j));
			}
		}
		
		int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int newX = x + dir[k][0];
				int newY = y + dir[k][1];
				if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'O') {
					board[newX][newY] = '~';
					q.add(new Point(newX, newY));
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '~') 
					board[i][j] = 'O';
			}
		}
    }
	
/**********************************************************************************************/
    // bfs 2
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        Queue<Integer> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    boolean surround = true;
                    q.add(i * n + j);
                    List<Integer> change = new ArrayList<>();
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int point = q.poll();
                        change.add(point);
                        int x = point / n;
                        int y = point % n;
                        for (int k = 0; k < dir.length; k++) {
                            int nextX = x + dir[k][0];
                            int nextY = y + dir[k][1];
                            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                                if (board[nextX][nextY] == 'O' && !visited[nextX][nextY])
                                    q.add(nextX * n + nextY);
                                visited[nextX][nextY] = true;
                            }
                            else
                                surround = false;
                        }
                    }
                    if (surround)
                        for (int p : change)
                            board[p / n][p % n] = 'X';
                }
            }
        }
    }
}
