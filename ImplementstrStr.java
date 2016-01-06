/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
    
    if (needle.length() == 0)
        return 0;
    if (needle.length() > haystack.length())
        return -1;
    int i, j;
    for (j = 0; j < haystack.length(); j++) {
            for (i = 0; i < needle.length() && i + j < haystack.length() && needle.charAt(i) == haystack.charAt(i + j); i++)
            ;
            if (i == needle.length())
                return j;
            if (i + j == haystack.length())
                return -1;
    }
    	return -1;
    }
    
}
    
