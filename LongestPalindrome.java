Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Note:
Assume the length of given string will not exceed 1,010.
Example:
Input:
"abccccdd"
Output:
7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] ss = s.toCharArray();;
        
        int[] count = new int[200];
        for (int i = 0; i < ss.length; i++) {
            count[ss[i] - 'A']++;                               // 注意A排在a的前面...
        }
        Arrays.sort(count);
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0)
                res += count[i];
            else {
                res += count[i] - 1;                            // 其中1个不用
                flag = true;
            }
        }
        if (flag)
        	res++;
        return res;
    }
}
