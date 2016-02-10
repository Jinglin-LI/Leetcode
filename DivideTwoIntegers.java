/*
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return dividend == Integer.MIN_VALUE? Integer.MAX_VALUE : -dividend;
        boolean neg = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int res = 0;
        for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; bit--) {
            if (ldividend >= (ldivisor << bit)) {
                res |= 1 << bit;                                                          // add the "1" in the certain bit
                ldividend -= ldivisor << bit;
            }
        }
        return neg? -res : res;
    }
}
