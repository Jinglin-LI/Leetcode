/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
// 将words存储进hm, 两个指针指向substring，每次i指针向后移动重新把hm存入temp（利于之后删除）。

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0)
            return res;
        int len = s.length();
        int m = words.length;
        int n = words[0].length();
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        int i = 0;
        while (i <= len - m * n) {
            HashMap<String, Integer> temp = new HashMap<>(hm);                      // 每次把之前存储的hm存入temp，来做删除工作。
            for (int j = 0; j < m; j++) {
                String tempStr = s.substring(i + j * n, i + (j + 1) * n);
                if (temp.containsKey(tempStr)) {
                    if (temp.get(tempStr) == 1)
                        temp.remove(tempStr);
                    else
                        temp.put(tempStr, temp.get(tempStr) - 1);
                }
                else
                    break;
            }
            if (temp.size() == 0)
                res.add(i);
            i++;
        }
        return res;
    }
}
