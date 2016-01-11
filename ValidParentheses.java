/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        if (s == null)
            return true;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']') {
                stack.push(s.charAt(i));
                i++;
            }
            
            if (i < s.length() && s.charAt(i) == ')') {
                if (stack.isEmpty() || !stack.pop().equals('('))
                    return false;
                i++;
            }
            
            if (i < s.length() && s.charAt(i) == '}') {
                if (stack.isEmpty() || !stack.pop().equals('{'))
                    return false;
                i++;
            }
            
            if (i < s.length() && s.charAt(i) == ']') {
                if (stack.isEmpty() || !stack.pop().equals('['))
                    return false;
                i++;
            }            
        }
        
        if (i == s.length() && stack.isEmpty())
            return true;
        
    return false;
    }
}
