/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
  
  // 可按照传统visited传入到DFS
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        boolean res = dfs(board, i - 1, j, index + 1, word, visited) ||
            dfs(board, i + 1, j, index + 1, word, visited) ||
            dfs(board, i, j + 1, index + 1, word, visited) ||
            dfs(board, i, j - 1, index + 1, word, visited);
        visited[i][j] = false;
        return res;
    }
  
  /**************************************************************************************/
  
  // 一样的方法。可以用‘~’标记visited，然后再改回来。
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        if (word.length() == 0)
            return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (dfs (board, word, i, j, 0))
                        return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (word.length() == index)                                                  // Note the usage of index and length() == index        
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        board[i][j] = '~';                                                           // visited
        boolean res = dfs(board, word, i - 1, j, index + 1) 
                   || dfs(board, word, i + 1, j, index + 1)
                   || dfs(board, word, i, j - 1, index + 1) 
                   || dfs(board, word, i, j + 1, index + 1);
        board[i][j] = word.charAt(index);
        return res;
    }
}
