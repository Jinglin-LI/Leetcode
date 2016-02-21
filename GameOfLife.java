/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null)
            return;
        int m = board.length;
        int n = board[0].length;
        int[][] marked = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (countSurr1(board, i, j) < 2 || countSurr1(board, i, j) > 3)
                        marked[i][j] = 1;
                }
                else {
                    if (countSurr1(board, i, j) == 3)
                        marked[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j] == 1) {
                    if (board[i][j] == 1)
                        board[i][j] = 0;
                    else
                        board[i][j] = 1;
                }
            }
        }
    }
    
    private int countSurr1(int[][] board, int i, int j) {
        int count = 0;
        int[][] surround = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};
        for (int k = 0; k < surround.length; k++) {
            int newI = i + surround[k][0];
            int newJ = j + surround[k][1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length)
                if (board[newI][newJ] == 1)
                    count++;
        }
        return count;
    }
}
