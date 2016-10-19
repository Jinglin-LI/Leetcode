/*
Given a string that consists of only uppercase English letters, 
you can replace any letter in the string with another letter at most k times. 
Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
Note:
Both the string's length and k will not exceed 104.
Example 1:
Input:
s = "ABAB", k = 2
Output:
4
Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input:
s = "AABABBA", k = 1
Output:
4
Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/
/*
此题难点在于要遍历整个A-Z. 之前试过从左到右，从右到左遍历数组，碰到例子(ABBBA, 2) 还是不过。
那么遍历A-Z, 记得将low也要滑动。
*/

public class Solution {
    public int characterReplacement(String s, int k) {
    	int res = 0;
    	for (int i = 0; i < 26; i++) {
    		char temp = (char)('A' + i);
    		int low = 0;
    		int high = 0; 
    		int count = 0;
    		while (high < s.length()) {
    			if (s.charAt(high) != temp)
    				count++;                              // 利用count记录A-Z的时候，需要替代的个数。不用将k值改变。
    			while (count > k) {
    				if (s.charAt(low) != temp)
    					count--;
    				low++;
    			}
    			res = Math.max(res, high - low + 1);
    			high++;
    		}
    	}
    	return res;
    }
}
