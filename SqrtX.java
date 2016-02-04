/*
Implement int sqrt(int x).
Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        int res = 0;
        if (x == 1)
            return 1;
        int low = 1, high = x / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long)mid * mid > x)                                      // Note the overflow!!!
                high = mid - 1;
            else if ((long)mid * mid <= x) {
                res = Math.max(res, mid);
                low = mid + 1;
            }
        }
        return res;
    }
}
