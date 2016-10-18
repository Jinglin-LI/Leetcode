/*
A sequence of number is called arithmetic if it consists of at least three elements and if the difference 
between any two consecutive elements is the same.
For example, these are arithmetic sequence:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7
A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
The function should return the number of arithmetic slices in the array A.
Example:
A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/
/*
此题题干有一定模糊性。是等差数列，-1,0,1,0,-1这种不算。
理解题干的参考： http://www.dongcoder.com/detail-200131.html

(1)首先，题目输入的数列是0索引的数组，注意，这个输入的数组的各个数字不一定是等差数列，比如说可能输入的是{1,2,5,6}。
(2)所求的P+1<Q，也就是说所求出的等比数列中至少包含3个元素，比如{1,2,3,4}中{1,2}就不算是arithmetic。
(3)所求的arithmetic在原数组中要求是位置连续的，比如原数组若给定的是{1,2,4,3}，
这里的{1,2,3}在原数组中并不连续，因此会返回0。而{1,3,5,6}中{1,3,5}位置则是连续的。
再举几个例子：
输入：{1,2} 返回0 。因为没有3个以上的元素。
输入：{1,3,5,6,7} 返回2。因为有{1,3,5}和{5,6,7}。而{1,3,5,7}则不算，因为它们在原数组里不连续。
输入：{1,3,5} 返回1。

显而易见：连续的等差数列有n个元素的时候，则会有(1+2+...+n)个等差子数列。
{1,2,3} -> {1,2,3} ->1
{1,2,3,4} -> {1,2,3,4} + {1,2,3} + {2,3,4} -> 1+2 ->3
{1,2,3,4,5} -> {1,2,3,4,5} + {1,2,3,4} + {2,3,4,5} + {1,2,3} + {2,3,4} + {3,4,5} -> 1+2+3 ->6
{1,2,....,n} -> ...... -> 1+2+...+n  

此题记录res时候很巧妙。例子：
        -1,0,1,2,3,5,6,7
     dp: 0,0,1,2,3,0,0,1.
    res: 0,0,1,3,6,0,0,7.
*/

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	int res = 0;
    	int[] dp = new int[A.length];
    	for (int i = 2; i < A.length; i++) {
    		if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
    			dp[i] = dp[i - 1] + 1;                    // 其余不与前两个构成等差数列的dp[]为0. 因为res只从第三个1开始算。比如dp = 0,0,1.
    		res += dp[i];                               // tricky here. 连续等差数列有n个元素，则有（1+2+...+n）个等差数列。
    	}
    	return res;
    }
}
