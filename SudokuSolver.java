/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
*/
// 循环处理子问题。每一个格子带入不同的九个数，判断是否合法。合法则继续递归，结束后把格子设定回去。
// 判断两个格子，当前加入的和之前是否冲突。

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return;
        helper(board, 0, 0);
    }
    private boolean helper(char[][] board, int i, int j) {
        if (j == 9)
            return helper(board, i + 1, 0);                   // j到最右边，换行重新开始
        if (i == 9)
            return true;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char)(k + '0');                // 注意由integer转换成char
                if (isValid(board, i, j)) {
                    if (helper(board, i, j + 1))              // 左右相邻的两个格子没有冲突(递归)
                        return true;
                }
                board[i][j] = '.';
            }
        }
        else
            return helper(board, i, j + 1);                   // 有数字的时候检测右边的，递归
        return false;
    }
    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {       // i/3*3 ！= i, 即i与j构成的小3*3的小格子里面判断是否valid
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}
