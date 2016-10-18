/*
Given a non-negative integer num represented as a string, 
remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
/*
这题自己做的太痛苦了...总是case想不完全。一开始想的是不删除，每次递归找最小值然后添加。但是最后几个char添加不上去。
还是利用sb删除好。注意（9,1）返回“0”。
*/

public class Solution {
    public String removeKdigits(String num, int k) {
		if (num == null || num.length() == 0 || k >= num.length())
			return "0";
		if (k == 0)
			return num;
		StringBuilder sb = new StringBuilder(num);          // 注意吧num都拷贝进来。
		int i = 0;
		while (i < k) {
			removeCurrChar(sb);                               // 遇到后面小于当前数的情况，就将当前数删掉。
			i++;
		}
		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.length() == 0? "0" : sb.toString();       // 都删除光了就h返回“0”。
	}	
	private void removeCurrChar (StringBuilder sb) {
		int i = 0;
		while (i + 1 < sb.length() && sb.charAt(i) <= sb.charAt(i + 1))
			i++;
		sb.deleteCharAt(i);
	}
}
