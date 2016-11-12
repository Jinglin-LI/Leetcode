/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/



// 用double值存储res. 最后再判断是否大于MAX_VALUE

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int flag = 1;
        double result = 0;
        int i = 0;
        if(str.charAt(0) == '-'){
            flag = -1;
            i++;
        }
        else if(str.charAt(0) == '+'){
            i++;
        }
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(flag == -1){
            result = -result;
        }
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}



/*----------------------------------------------------------------------------------------*/

// 此方法要比较最后一位是否大于Max value

public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int sum = 0;
        int i = 0;
//      for (i = 0; str.charAt(i) == ' ' && i < str.length(); i++)
//      ;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i < str.length() && str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        else if (i < str.length() && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            int digit = str.charAt(i) - '0';
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE / 10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + digit;
        }
        return sum * sign;
    }
}
