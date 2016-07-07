/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean flagM = false, flagN = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						flagN = true;
					if (j == 0)
						flagM = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
			}
		}
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++)
					matrix[i][j] = 0;
			}
		}
		if (flagM) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
		if (flagN) {
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
	}
}
