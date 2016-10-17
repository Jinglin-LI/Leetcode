/**
Find the length of the longest substring T of a given string 
(consists of lowercase letters only) such that every character in T appears no less than k times.
Example 1:
Input:
s = "aaabb", k = 3
Output:
3
The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:
Input:
s = "ababbc", k = 2
Output:
5
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

/*
找断点，记录进list. list里面加入最前面的-1和最后面的len.
例如： (ababacb, 3), list中存入-1， 5， 7. 
然后每一段进行递归寻找最大长度。注意start和end要减去那个断点。例如最后递归时，(start = 0, end = 5), (start = 6, end = 7). 
*/
// 原先想用两个指针的方法记录，但是（ababacb，3）的例子就错了。

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k)
			return 0;
		int len = s.length();
		if (k <= 1)
			return len;
		int[] count = new int[26];
		int res = 0;
		for (int i = 0; i < len; i++)
			count[s.charAt(i) - 'a']++;
		List<Integer> pos = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (count[s.charAt(i) - 'a'] < k)
				pos.add(i);
		}
		if (pos.size() == 0)
			return len;
		pos.add(0, -1);
		pos.add(len);
		for (int i = 1; i < pos.size(); i++) {
			int start = pos.get(i - 1) + 1;
			int end = pos.get(i);
			res = Math.max(res,  longestSubstring(s.substring(start,  end), k));
		}
		return res;	
    }
}
