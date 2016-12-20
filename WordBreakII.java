/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is ["cats and dog", "cat sand dog"].


WordBreakI 只要求返回是否可以break,用DP+boolean记前面的是否break即可。
WordBreakII 要求返回所有的带有空格的word. DP方法繁琐，可以用DFS的方法，加上I中判断isBreakable避免长字符且无法break的LTE. 
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
		if (s == null || wordDict == null)
			return res;
		helper(res, s, wordDict, 0, "");
		return res;
	}
	public void helper(List<String> res, String s, Set<String> dict, int start, String str) {
		if (!isBreakable(s, dict))
			return;
		if (start >= s.length()) {
			res.add(str);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (dict.contains(sb.toString())) {
				String newStr = str.length() > 0? (str + " " + sb.toString()) : sb.toString();    
				helper(res, s, dict, i + 1, newStr);
			}
		}
	}
	
	public boolean isBreakable(String s, Set<String> dict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] == true && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
