/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
*/
// two pointer, store the true part using boolean[i], finally to the end of string.

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] index = new boolean[s.length() + 1];
        index[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (index[j] && wordDict.contains(s.substring(j, i))) {
                    index[i] = true;
                    break;
                }
            }
        }
        return index[s.length()];
    }
}
