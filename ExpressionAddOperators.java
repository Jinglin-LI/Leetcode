/*
Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/
/*
注意原题目要求里没有提到括号的存在，因此需要考虑乘号出现的情况。
例子，2 + 3 * 5， 先2 + 3得到5（sum），发现（或者说，可以自己加入）乘号了，2为lastProduct, 5(sum) - 2(lastProduct)之后再乘以5
2 + 3 * 5 * 6. 先2 + 3 得到5， 乘以5利用前面的相减相乘得到25. 发现还是乘号，（3 * 5）作为lastProduct, 
用25(sum) - 15(lastProduct)之后加上lastProduct * curValue. 上一例中，2也可以当做是几个数的乘积。
因为String可能很长，用long。
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, target, 0, 0, "", res);
        return res;
    }
    private void helper(String num, int target, long lastProduct, long sum, String str, List<String> res) {
        if (num.length() == 0 && sum == target) {
            res.add(str);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {                       // 搜索可能的拆分情况，1 + 2 + 3 或者12 + 3.
            String curStr = num.substring(0, i);
            if(curStr.length() > 1 && curStr.charAt(0) == '0')
                continue;
            String rest = num.substring(i);                             // rest作为下一轮递归时候的num.
            long curValue = Long.parseLong(curStr);
            if (str.length() == 0) {
                helper(rest, target, curValue, curValue, str + curValue, res);
            }
            else {
                // 相加，相加和作为之前的乘积
                helper(rest, target, curValue, sum + curValue, str + "+" + curValue, res);
                // 相减，相减结果作为之前的乘积
                helper(rest, target, -curValue, sum - curValue, str + "-" + curValue, res);
                // 相乘，相乘结果作为之前的乘积
                helper(rest, target, curValue * lastProduct, sum - lastProduct + lastProduct * curValue, str + "*" + curValue, res);
            }
        }
    }
}
