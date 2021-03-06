/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null)
            return true;
        if (pattern == null || str == null)
            return false;
        HashMap<Character, String> hm = new HashMap<>();
        String[] s = str.split(" ");
        if (s.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!hm.get(pattern.charAt(i)).equals(s[i]))
                    return false;
            }
            else {
                if (hm.containsValue(s[i]))
                    return false;
                hm.put (pattern.charAt(i), s[i]);
            }
        }
        return true;
    }
}
