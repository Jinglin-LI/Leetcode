/*
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public class Solution {
    public int calculate(String s) {
        int res = 0;
        int preSum = 0;
        int sign = 1;                                                              // 1 for '+', -1 for '-', 2 for '*', 3 for '/'
        Stack<Integer> stack = new Stack<>();                                      // store the only +- elements 
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                preSum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    preSum = preSum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) {
                    sign = stack.pop();
                    int a = stack.pop();                                          // use a to store the element before '*' or '/'
                    if (sign == 2)
                        stack.push(a * preSum);                                   // use preSum to store the element after '*' or '/'
                    else if (sign == 3)
                        stack.push(a / preSum);
                }
                else
                    stack.push(preSum);
            }
            else if (s.charAt(i) == '+')
                stack.push(1);
            else if (s.charAt(i) == '-')
                stack.push(-1);
            else if (s.charAt(i) == '*')
                stack.push(2);
            else if (s.charAt(i) == '/')
                stack.push(3);
        }
        while (!stack.isEmpty()) {                                                   // element, sign, element, sign...element
            if (stack.size() > 1) {
                res = res + stack.pop() * stack.pop();
            }
            else
                res = res + stack.pop();
        }
        return res;
    }
}
