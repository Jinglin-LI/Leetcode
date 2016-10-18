/*
Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, 
empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. 
In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is not a valid board - as battleships will always have a cell separating between them.
*/

/*
The ship can have different sizes. either to be positioned in horizon or vertical. 
This code is find the right-bottom 'X', when finished by '.', res++.
*/

public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int m = board.length;
        int n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if ((i + 1 >= m || board[i + 1][j] == '.') && (j + 1 >= n || board[i][j + 1] == '.'))
                        res++;
                }
            }
        }
        return res;
    }
}
