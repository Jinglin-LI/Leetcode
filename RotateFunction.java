/*
Given an array of integers A and let n to be its length.
Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
Calculate the maximum value of F(0), F(1), ..., F(n-1).
Note:
n is guaranteed to be less than 105.
Example:
A = [4, 3, 2, 6]
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
*/
// https://discuss.leetcode.com/topic/58459/java-o-n-solution-with-explanation/2
/*
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
       = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
Then,
F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
              = sum - nBk[0]
Thus,
F(k) = F(k-1) + sum - nBk[0]
What is Bk[0]?

k = 0; B[0] = A[0];
k = 1; B[0] = A[len-1];
k = 2; B[0] = A[len-2];
...
*/
// 数学推导方程

public class Solution {
    public int maxRotateFunction(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];                        // F(0)
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];          // 根据推导公式
            max = Math.max(F, max);
        }
        return max;   
    }
}

/*
http://bookshadow.com/weblog/2016/09/11/leetcode-rotate-function/
假设数组A的长度为5，其旋转函数F的系数向量如下所示：
0 1 2 3 4
1 2 3 4 0
2 3 4 0 1
3 4 0 1 2
4 0 1 2 3
用每一行系数与其上一行做差，差值恰好为sum(A) - size * A[size - x]，其中x为行数
（因为已经加上了sum, 所以0-4实际上要减去5 * A[size - x]).
*/

public class RotationFunction {
	public int maxRotateFunction(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		int eachLineSum = 0;
		int len = A.length;
		for (int i = 0; i < len; i++) {
			eachLineSum += i * A[i];                  // 第一行的sum. 
		}
		int res = eachLineSum;
		for (int i = len - 1; i >= 0; i--) {        // 从最后一个算起，即size - x. 
			eachLineSum += sum - len * A[i];
			res = Math.max(res, eachLineSum);
		}
		return res;
	}
}
