/*
Given two strings s and t, write a function to determine if t is an anagram of s. (Anagram is, rearranging the letters of a word or phrase to produce a new word or phrase, using all the original letters exactly once)

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            else {
                hm.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (!hm.containsKey(t.charAt(i))) {
                return false;
            }
            else {
                if (hm.get(t.charAt(i)) == 0)
                    return false;
                else
                    hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
            }
        }
        return true;
    }
    
    public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] count = new int[26];
		for (Character c : s.toCharArray()) {
			count[c - 'a']++;
		}
		for (Character c : t.toCharArray()) {
			count[c - 'a']--;
			if (count[c - 'a'] < 0)
				return false;
		}
		return true;
	}
}

