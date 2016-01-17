/*
Determine if a Sudoku is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int j = 0; j < 9; j++) {
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.' || !hs.contains(board[i][j])) {
                    hs.add(board[i][j]);
                }
                else 
                    return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.' || !hs.contains(board[i][j]))
                    hs.add(board[i][j]);
                else
                    return false;
            }
        }
        
        int len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        
        len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 3; j < 6; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        
        len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 6; j < 9; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        return true;
    }
}
