/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
// 用stack，存储'('的index，当i指向')'时，pop出相应的一个'('， 如果stack不为空，接着用i-stack.peek(). 如果stack为空，i与start相减，重新设定start。

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int start = -1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) 
                        res = Math.max(res, i - stack.peek());
                    
                    else 
                        res = Math.max(res, i - start);
                }
                else
                    start = i;
            }
        }
        return res;
    }
}
