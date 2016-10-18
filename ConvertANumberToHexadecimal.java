/*
Given an integer, write an algorithm to convert it to hexadecimal. 
For negative integer, two’s complement method is used.
Note:
All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. 
If the number is zero, it is represented by a single zero character '0'; 
otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:
Input:
26
Output:
"1a"
Example 2:
Input:
-1
Output:
"ffffffff"
*/

public class Solution {
    public String toHex(int num) {
		char[] dic = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b', 'c', 'd', 'e', 'f'};
		StringBuilder sb = new StringBuilder();
		if (num == 0)
		    return "0";
		while (num != 0) {
			sb.append(dic[num & 15]);
			num >>>= 4;                               // >>>无符号右移。之前的bit补零。只是>>的话，MLE 不知为何。
		}
		return sb.reverse().toString();
	}
}
