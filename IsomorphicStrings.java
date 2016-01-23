/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
<b>Given "ab", "aa", return false.</b>
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 && t.length() == 0)
            return true;
        
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                if (hm.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            
            if (!hm.containsKey(s.charAt(i))) {
                if (hs.contains(t.charAt(i)))
                    return false;
                hm.put(s.charAt(i), t.charAt(i));
                hs.add(t.charAt(i));
            }
        }
        return true;
    }
}
