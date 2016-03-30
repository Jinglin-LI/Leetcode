/*
Given a string of numbers and operators, 
return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
// 巧妙的递归。对任意一个字符i, 若它是运算符，分成左右两边。递归得到左边和右边运算结果的list。 
// 每一个左边值跟每一个右边值进行运算。（i之后也要移动）
// 若字符串input中没有运算符，则直接将字符串转化为整型数放入结果集中。

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int m : left) {
                    for (int n : right) {
                        switch(ch) {
                            case '+':
                                res.add(m + n);
                                break;
                            case '-':
                                res.add(m - n);
                                break;
                            case '*':
                                res.add(m * n);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.parseInt(input));
        return res;
    }
}
