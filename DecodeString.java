/*
Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; 
No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].
Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
// 递归。例如，34[ab]4[b5[c]]. 后面b5[c]再递归之后返回。

public class DecodeString {
	public String decodeString(String s) {
		if (s == null || s.length() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int digit_begin = i;
				while (s.charAt(i) != '[')
					i++;
				int num = Integer.valueOf(s.substring(digit_begin, i));
				int count = 1;
				int str_begin = i + 1;
				i++;
				while (count != 0) {
					if (s.charAt(i) == '[')
						count++;
					else if (s.charAt(i) == ']')
						count--;                                                          // 用count记录[]闭合。
					i++;
				}
				i--;
				String str = decodeString(s.substring(str_begin, i));                 // 递归在此
				for (int j = 0; j < num; j++)
					sb.append(str);
			}
			else
				sb.append(c);
		}
		return sb.toString();
	}
}
