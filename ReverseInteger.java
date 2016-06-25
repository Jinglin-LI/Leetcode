/*
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class Solution {
    public int reverse(int x) {
    int sum = 0;
	
    while (x != 0) {
		if (Math.abs(sum) > Integer.MAX_VALUE / 10)
			return 0;
        sum = sum * 10 + x % 10;
        x = x / 10;
    }
	  return sum;
  }
}
