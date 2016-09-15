/*
Given a positive integer n and you can do operations as follow:
If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?
Example 1:
Input:
8
Output:
3
Explanation:
8 -> 4 -> 2 -> 1
Example 2:
Input:
7
Output:
4
Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
*/
// https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-with-explanations
/* 
   101 -> 100 -> 10 -> 1
   101 -> 110 -> 11 -> 100 -> 10 -> 1     其中，101 -> 110 增加了一次计算 11 -> 100 增加了一次计算。
   所以，(n >>> 1) & 1 || n == 3来判断应该减一而不是加一。
   n >>> 1 是 unsigned 的数字的运算右移。
*/

public class IntegerReplacement {
	public static void main(String[] args) {
		System.out.println(new IntegerReplacement().integerReplacement(3));
	}
	public int integerReplacement(int n) {
		int res = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			}
			else if (n == 3 || ((n >>> 1) & 1) == 0) {
				n--;
			}
			else
				n++;
			res++;
		}
		return res;
	}
}
