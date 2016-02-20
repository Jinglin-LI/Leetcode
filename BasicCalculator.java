/*
Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/

public class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int preSum = 0;
        Stack<Integer> stack = new Stack<>();                           // store the preSum and sign before '('
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                preSum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    preSum = preSum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res = res + preSum * sign;
            }
            else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(res);                                        // store the previous result in the stack before '('
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();                  // pop sign and previous result
            }
        }
        return res;
    }
}
