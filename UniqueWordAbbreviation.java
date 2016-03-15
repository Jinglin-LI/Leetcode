/*
Total Accepted: 351 Total Submissions: 2106 Difficulty: Easy
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
a) it                      --> it    (no abbreviation)
b) d|o|g                   --> d1g
c) i|nternationalizatio|n  --> i18n
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]
isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/
// 注意题目要求：这个单词的缩写是独一的，在词典中除了它本身以外，不存在跟他一样的缩写。

import java.util.*;
public class ValidWordAbbr {
	public HashMap<String, List<String>> hm = new HashMap<>();
	public ValidWordAbbr(String[] dictionary) {
		for (String s : dictionary) {
			String key = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
			if (hm.containsKey(key)) {
				hm.get(key).add(s);
			}
			else {
				List<String> newList = new ArrayList<>();
				newList.add(s);
				hm.put(key, newList);
			}
		}
	}
	public boolean isUnique(String word) {
		String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
		if (!hm.containsKey(key))
			return true;
		else if (hm.get(key).size() < 2 && hm.get(key).get(0).equals(word))
			return true;
		return false;
	}
}
