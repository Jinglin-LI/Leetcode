/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
// 此题不管是否假设，所有的单词都会以同一个字母开始。遍历整个字符串数组。

public class LongestCommonPrefix {
	public static void main (String[] args) {
		String[] s = {"ab", "abc", "a", "abcd"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix2(s));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for (String s : strs) {
				if (i == s.length() || s.charAt(i) != ch)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];								// if String[] strs contains one element
	}
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int minLength = Integer.MAX_VALUE;
		String res = "";
		
		// find the shortest string
		for (int i = 0; i < strs.length; i++) {
			minLength = Math.min(minLength, strs[i].length());
		}
		
		// used the shortest length, add the characters
		for (int i = 0; i < minLength; i++) {
			char ch = strs[0].charAt(i);
			for (String s : strs) {
				if (ch != s.charAt(i))
					return res;
			}
			res += ch;
		}
		return res;
	}
}
