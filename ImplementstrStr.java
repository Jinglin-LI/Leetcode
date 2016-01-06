/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
    int index = haystack.indexOf(needle);  
        if(index < 0)      
            return -1;  
        else            
            return index;
    }
}
    
