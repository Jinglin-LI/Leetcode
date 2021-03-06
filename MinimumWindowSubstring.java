/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
/*
left和right两个指针。
用HM存t中元素, 然后遍历整个母串s。
count来计数母串s中跟t中相同的元素的个数。当达到t的长度后，说明前面的substring包含所需substring。
利用left指针找第一个在HM中存在的数（while语句忽略s中非t中存在的元素），并将元素要重新压入HM， 作为下一轮right向后查找时，供HM中某元素个数可减一的dictionary。
count--.
*/

public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return res;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!hm.containsKey(t.charAt(i)))
                hm.put(t.charAt(i), 1);
            else
                hm.put(t.charAt(i), hm.get(t.charAt(i)) + 1);
        }
        int count = 0;
        int left = 0;
        int minLen = s.length() + 1;
        for (int right = 0; right < s.length(); right++) {
            if (hm.containsKey(s.charAt(right))) {
                hm.put(s.charAt(right), hm.get(s.charAt(right)) - 1);
                if (hm.get(s.charAt(right)) >= 0)
                    count++;
                while (count == t.length()) {
                    if (hm.containsKey(s.charAt(left))) {
                        hm.put(s.charAt(left), hm.get(s.charAt(left)) + 1);
                        if (hm.get(s.charAt(left)) > 0) {
                            if (right - left + 1 < minLen) {
                                res = s.substring(left, right + 1);
                                minLen = right - left + 1;
                            }
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return res;
    }
    
    /*==========================================================================================*/
    
    // 方法一样，只不过不用HM, 而是数组
    public String minWindow(String s, String t) {
        int res = s.length();
		int[] tHash = new int[255];
		int[] sHash = new int[255];
		for (int i = 0; i < t.length(); i++) {
			tHash[t.charAt(i)]++;
		}
		int start = 0;
		int count = 0;
		
		// 用以最后返回substring的两个index
		int left = -1;
		int right = s.length();
		
		for (int i = 0; i < s.length(); i++) {
			sHash[s.charAt(i)]++;
			if (sHash[s.charAt(i)] <= tHash[s.charAt(i)]) {
				count++;
			}
			if (count == t.length()) {
				while (start < i && sHash[s.charAt(start)] > tHash[s.charAt(start)]) {
					sHash[s.charAt(start)]--;
					start++;
				}
				if (i - start < res) {
					res = i - start;
					left = start;
					right = i;
				}
				
				// 开始下一个，从start++那个字符开始
				sHash[s.charAt(start)]--;
				count--;
				start++;
			}
		}
		return left == -1? "" : s.substring(left, right + 1);
    }
}
