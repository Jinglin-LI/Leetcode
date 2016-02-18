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
