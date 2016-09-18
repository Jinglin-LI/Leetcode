/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' ,
both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
// Queen可以横竖斜的走，所以queens[m] = n代表Q的横纵坐标m与n。判断n都不相同，再判断斜着不同（与前面的Q相比，横坐标之差不等于纵坐标之差）
// DFS，每一行作为分支进行搜索。

import java.util.*;
public class NQueens {
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4));
	}
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		int[] queens = new int[n];
		helper(queens, res, 0, n);
		return res;
	}
	private void helper(int[] queens, List<List<String>> res, int row, int n) {
		if (row == n) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (queens[i] != j)
						sb.append('.');
					else
						sb.append('Q');
				}
				list.add(sb.toString());
			}
			res.add(list);
			return;
		}
		for (int i = 0; i < n; i++) {
			queens[row] = i;
			if (check(row, queens))                      // 与前面的Q进行比较。
				helper(queens, res, row + 1, n);
		}
	}
	private boolean check(int row, int[] queens) {
		for (int i = 0; i < row; i++) {
			if (queens[row] == queens[i] || Math.abs(queens[row] - queens[i]) == row - i)
				return false;
		}
		return true;
	}
}
