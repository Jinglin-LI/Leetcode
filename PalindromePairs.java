/*
Given a list of unique words. 
Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, 
i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/
/* 
1. 遍历words[], words[i]翻转，hm中存在翻转值并且index不同于原String的则返回两个值。（“bat”, "tab"）
   那么对于情况("dcba", "ljlabcd")：
2. 遍历words[], 利用j将words[i]分为任意两部分（遍历），前缀如果是回文，翻转后缀并查看是否在hm.
3. 同理，后缀如果是回文，翻转前缀查看。2与3可以与1合并。所以3要判断后缀是否为“”，否则2中已经囊括前缀为“”的情况，重复了。
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2)
            return res;
        HashMap<String, Integer> hm = new HashMap<>();                // 利用hm记载String在words[]中的位置
        for (int i = 0; i < words.length; i++)
            hm.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String reverseStr2 = new StringBuilder(str2).reverse().toString();
                    if (hm.containsKey(reverseStr2) && hm.get(reverseStr2) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(hm.get(reverseStr2));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(str2)) {
                    String reverseStr1 = new StringBuilder(str1).reverse().toString();
                    if (hm.containsKey(reverseStr1) && hm.get(reverseStr1) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(hm.get(reverseStr1));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
