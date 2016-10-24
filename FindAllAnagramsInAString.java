/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().findAnagrams("ababa", "ab"));
	}
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p == null || p.length() == 0 || s == null || s.length() == 0)
            return res;
        int[] dic = new int[26];
        Arrays.fill(dic, 0);
        for (int i = 0; i < p.length(); i++) {
            dic[p.charAt(i) - 'a']++;
     //       System.out.println(dic[0]);
        }
        int low = 0;
        int high = 0;
        while (low < s.length() && high < s.length()) {
            while (low == high && low < s.length() && high < s.length() && dic[s.charAt(low) - 'a'] < 1) {
                low++;
                high++;
       //         System.out.println(high);
            }
            while (high < s.length() && dic[s.charAt(high) - 'a'] >= 1) {
                dic[s.charAt(high) - 'a']--;
                high++; 
            }
            if (high - low == p.length()) {
                res.add(low);
            }
            if (low < s.length()) {
            	dic[s.charAt(low) - 'a']++;
            	low++;
            }
        }
        return res;
    }
}
