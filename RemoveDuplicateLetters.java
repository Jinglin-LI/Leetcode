/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/
// Note the sequence    窗口题。遍历string，每个元素加入到sb中，遇到比sb最后一个元素小、并且这个元素有重复的话，删掉这个元素。

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];                                         // mark the number of 26 words
        boolean[] visited = new boolean[26];                               // mark the duplicates
    	StringBuilder sb = new StringBuilder();
    	char[] cArray = s.toCharArray();
    	for (char c : cArray) {
    		count[c - 'a']++;
    	}
    	for (char c : cArray) {
    		count[c - 'a']--;
    		if (visited[c - 'a'] == true)                                     // ingore the duplicates
    			continue;
    		while (sb.length() > 0 && c <= sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
    			visited[sb.charAt(sb.length() - 1) - 'a'] = false;
    			sb.deleteCharAt(sb.length() - 1);                               // delete the element greater than c
    		}
    		sb.append(c);
    		visited[c - 'a'] = true;
    	}
        return sb.toString();
    }
}
