/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0)
            return res;

        helper(res, n, 1, 0, "(");
        return res;
    }
    private void helper(List<String> res, int n, int leftN, int rightN, String str) {
        if (leftN == n && rightN == n)
            res.add(str);
            
        if (leftN < n)
            helper(res, n, leftN + 1, rightN, str + "(");
        if (leftN > rightN)                                                             // leftN > rightN
            helper(res, n, leftN, rightN + 1, str + ")");
    }
}
