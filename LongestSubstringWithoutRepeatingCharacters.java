/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();                             
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                res = Math.max (res, hm.size());
                i = hm.get(arr[i]);                               // when meet with the repeated character, point to (hm. get(arr[i]) + 1) after loop
                hm.clear();
            }
            else {
                hm.put(arr[i], i);                                // key is character, value is its index
            }
        }
        return Math.max(res, hm.size());                          // pull out the non-repeating condition
    }
}
