/*
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
    public String reverseWords(String s) {
        String trims = s.trim();
        if (trims == null)
            return null;
        String[] str = trims.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = str.length - 1; i > 0; i--) {
            if (str[i].length() > 0)                      // rull out the null in the str array (continous blank)
                sb.append(str[i] + " ");
        }
        sb.append(str[0]);
        return sb.toString();
    }
}
