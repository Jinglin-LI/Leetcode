/*
Given an integer n, find the closest integer (not including itself), which is a palindrome. 
The ‘closest’ is defined as absolute difference minimized between two integers.

Example 1: 
Input: “123” 
Output: “121”

Note: 
The input n is a positive integer represented by string, whose length will not exceed 18. 
If there is a tie, return the smaller one as answer.
*/

// https://discuss.leetcode.com/topic/88897/java-solution-with-detailed-proof/2
// 左边翻到右边去
// 三个选项：本身，左边-1， 左边+1 再比较与原数儿的绝对值。

public class FindTheClosestPalindromic {
	public String nearestPalindromic(String n) {
		char[] arr = n.toCharArray();
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			arr[j] = arr[i];
		}
		String curP = String.valueOf(arr);
		String preP = nearestPalindrom(curP, false);
		String nextP = nearestPalindrom(curP, true);
		
		long num = Long.valueOf(n);
		long cur = Long.valueOf(curP);
		long pre = Long.valueOf(preP);
		long next = Long.valueOf(nextP);
		
		long d1 = Math.abs(num - pre);
		long d2 = Math.abs(num - cur);
		long d3 = Math.abs(num - next);
		
		if (num == cur) {                                     // curP 为原数儿直接左边翻到右边
			return d1 <= d3? preP : nextP;
		}
		else if (num > cur) {
			return d2 <= d3? curP : nextP;
		}
		else {
			return d1 <= d2? preP : curP;
		}
	}
	
	private String nearestPalindrom(String curP, boolean dir) {     // dir 为小于或者大于原数儿的回文词
		int k = curP.length() / 2;
		int p = curP.length() - k;
		int l = Integer.valueOf(curP.substring(0, p));
		l += (dir? 1 : -1);
		
		if (l == 0) {
			return k == 0? "0" : "9";                                   // 十以下的原数儿
		}
		
		StringBuilder left = new StringBuilder(String.valueOf(l));      // l 为左边的一半加一或者减一
		StringBuilder right = new StringBuilder(left).reverse();
		
		if (k > left.length()) {
			right.append("9");
		}
		return left.append(right.substring(right.length() - k)).toString();
	}
}
