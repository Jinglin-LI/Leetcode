/*
Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
*/
// substring(0, i + 1) is first number, substring(i + 1, j + 1) is second number,substring(j + 1) is remaining.
// i 自增到中间，j自增到中间。num.length() - Math.max(i + 1, j - i)中，i + 1是i走到中间的情况；j - i 是j走到中间的情形。
// isAdditiveNumber2中，更加容易理解。num.length() - j也就是最后一个数长度要大于第二个数，最后一个数长度大于第一个数。
// 否则，否则111, 分为1， 11,。第三个数为空也会成为true. 此题注意条件。

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2)
            return false;
        
        for (int i = 0; i < (num.length() - 1) / 2; i++) {
            for (int j = i + 1; j < num.length() - Math.max(i + 1, j - i); j++) {               // 注意条件
                if (isValid(num.substring(0, i + 1), num.substring(i + 1, j + 1), num.substring(j + 1)))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isAdditiveNumber2(String num) {
		if (num == null || num.length() <= 2)
			return false;
		for (int i = 0; i < (num.length() - 1) / 2; i++) {
			for (int j = i + 1; num.length() - j >= j - i && num.length() - j >= i; j++) {      // 注意条件
				String str1 = num.substring(0, i + 1);
				String str2 = num.substring(i + 1, j + 1);
				String str3 = num.substring(j + 1);
				if (isValid(str1, str2, str3))
					return true;
			}
		}
		return false;
	}
    private boolean isValid(String s1, String s2, String remain) {
        if (remain == null || remain.length() == 0)					      // 注意第三个数为空的时候为结束。
            return true;
        if (s1.charAt(0) == '0' && s1.length() > 1)                                           // note the s1.length() > 1
            return false;
        if (s2.charAt(0) == '0' && s2.length() > 1)
            return false;
        String preSum = String.valueOf(Long.parseLong(s1) + Long.parseLong(s2));	      // String转为long, 再转为String
        if (!remain.startsWith(preSum))                                                       // note the string.startsWith(String s)
            return false;
        return isValid(s2, preSum, remain.substring(preSum.length()));                        // recursive

    }
}
