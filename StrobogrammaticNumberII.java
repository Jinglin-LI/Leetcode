/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/
// 双数，从validNumbers里面插入一个则对应findMatch里面插入一个，再从StringBuilder中间insert
// 单数，在n - 1做完双数操作之后，将每一个res都插入每一个singleNumber，其中每一个res都用temp存储然后insert, 再存储在res中。

import java.util.*;
public class Solution {
	private char[] validNumbers = new char[] {'0','1','6','8','9'};
	private char[] singleNumber = new char[] {'0', '1', '8'};
	
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0)
			return res;
		if (n == 1) {
			for (char c : singleNumber) {
				res.add(String.valueOf(c));
			}
			return res;
		}
		if (n % 2 == 0) {
			helper(n, new StringBuilder(), res);
		}
		else {
			helper(n - 1, new StringBuilder(), res);
			List<String> temp = new ArrayList<>();
			for (String s : res) {
				for (char c : singleNumber) {
					temp.add(new StringBuilder(s).insert(s.length() / 2, c).toString());
				}
			}
			res = temp;
		}
		return res;
	}
	
	private void helper(int n, StringBuilder sb, List<String> res) {
		if (sb.length() > n)
			return;
		if (sb.length() == n) {
			if (sb.length() > 0 && sb.charAt(0) != '0') {
				res.add(sb.toString());
			}
			return;
		}
		for (char c : validNumbers) {
			StringBuilder temp = new StringBuilder(sb);
			String s = "" + c + findMatch(c);
			temp.insert(temp.length() / 2, s);
			helper(n, temp, res);
		}
	}
	
	private char findMatch(char c) {
		switch(c) {
		case '1':
			return '1';
		case '6':
			return '9';
		case '8':
			return '8';
		case '9':
			return '6';
		case '0':
			return '0';
		default:
			return 0;
		}
	}
}
