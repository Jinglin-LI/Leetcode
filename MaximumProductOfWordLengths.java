/*
Given a string array words, 
find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
// 位操作。预处理words[]中每一个String的每一位，将1向左移动（words[i].charAt(j) - ‘a’）位确定该单词有这个字母（单词内可重复）。
// 然后重新遍历两个数，是否有重复位。没有的算长度最大乘积。

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] elements = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((elements[i] & elements[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
