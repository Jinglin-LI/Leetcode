/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String res = commonPre(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            res = commonPre(res, strs[i]);
        }
        return res;
    }

    private String commonPre(String s1, String s2) {
        if (s1 == null || s2 == null)
            return null;
        int len = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();                                // Note the usage of object, or use String s == ""
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;                                                         // Note the prefix
            else                                                              
                sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
    
}
