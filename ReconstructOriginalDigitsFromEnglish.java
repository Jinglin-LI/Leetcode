/*
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. 
That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"
Output: "012"
Example 2:
Input: "fviefuro"
Output: "45"
*/

public class Solution {
    public String originalDigits(String s) {
	        StringBuilder sb = new StringBuilder();
	        int[] a = new int[10];
	        int[] dic = new int[26];
	        for (int i = 0; i < s.length(); i++) {
	        	dic[s.charAt(i) - 'a']++;
	        }
	        if (dic['z' - 'a'] > 0) {
	        	int count = dic['z' - 'a'];
	        	a[0] = count;
	        	dic['z' - 'a'] -= count;
	        	dic['e' - 'a'] -= count;
	        	dic['r' - 'a'] -= count;
	        	dic['o' - 'a'] -= count;
	        }
	        if (dic['w' - 'a'] > 0) {
	        	int count = dic['w' - 'a'];
	        	a[2] = count;
	        	dic['w' - 'a'] -= count;
	        	dic['t' - 'a'] -= count;
	        	dic['o' - 'a'] -= count;
	        }
	        if (dic['x' - 'a'] > 0) {
	        	int count = dic['x' - 'a'];
	        	a[6] = count;
	        	dic['s' - 'a'] -= count;
	        	dic['i' - 'a'] -= count;
	        	dic['x' - 'a'] -= count;
	        }
	        if (dic['g' - 'a'] > 0) {
	        	int count = dic['g' - 'a'];
	        	a[8] = count;
	        	dic['e' - 'a'] -= count;
	        	dic['i' - 'a'] -= count;
	        	dic['g' - 'a'] -= count;
	        	dic['h' - 'a'] -= count;
	        	dic['t' - 'a'] -= count;
	        }
	        if (dic['u' - 'a'] > 0) {
	        	int count = dic['u' - 'a'];
	        	a[4] = count;
	        	dic['f' - 'a'] -= count;
	        	dic['o' - 'a'] -= count;
	        	dic['u' - 'a'] -= count;
	        	dic['r' - 'a'] -= count;
	        }
	        if (dic['f' - 'a'] > 0) {
	        	int count = dic['f' - 'a'];
	        	a[5] = count;
	        	dic['f' - 'a'] -= count;
	        	dic['i' - 'a'] -= count;
	        	dic['v' - 'a'] -= count;
	        	dic['e' - 'a'] -= count;
	        }
	        if (dic['v' - 'a'] > 0) {
	        	int count = dic['v' - 'a'];
	        	a[7] = count;
	        	dic['s' - 'a'] -= count;
	        	dic['e' - 'a'] -= count * 2;
	        	dic['v' - 'a'] -= count;
	        	dic['n' - 'a'] -= count;
	        }
	        if (dic['h' - 'a'] > 0) {
	        	int count = dic['h' - 'a'];
	        	a[3] = count;
	        	dic['t' - 'a'] -= count;
	        	dic['h' - 'a'] -= count;
	        	dic['r' - 'a'] -= count;
	        	dic['e' - 'a'] -= count * 2;
	        }
	        if (dic['o' - 'a'] > 0) {
	        	int count = dic['o' - 'a'];
	        	a[1] = count;
	        	dic['o' - 'a'] -= count;
	        	dic['n' - 'a'] -= count;
	        	dic['e' - 'a'] -= count;
	        }
	        if (dic['i' - 'a'] > 0) {
	        	int count = dic['i' - 'a'];
	        	a[9] = count;
	        }
	        for (int i = 0; i < 10; i++) {
	        	for (int j = 0; j < a[i]; j++) {
	        		sb.append(i);
	        	}
	        }
	        return sb.toString();
	    }
}
