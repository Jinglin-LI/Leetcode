/*
Write a program to find the nth super ugly number.
Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers, 
given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/
// 这次用数组indexOfPrimes[]存储需要相乘的primes[]的index. Reference: http://www.cnblogs.com/Liok3187/p/5016076.html

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] superUglyNumbers = new int[n];
        superUglyNumbers[0] = 1;
        
        int[] indexOfPrimes = new int[primes.length];                     // 记录的是需要相乘的primes[]的index
        Arrays.fill(indexOfPrimes, 0);                                    // 初始化为0，因为每个素数都要乘以primes[0], 即1.

        int count = 1;
        while (count < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {                     // 遍历素数数组（因数不同而每次数组不同），找最小的值
                int temp = superUglyNumbers[indexOfPrimes[i]] * primes[i];
                min = Math.min(min, temp);
            }
            for (int i = 0; i < primes.length; i++) {
                if (min == superUglyNumbers[indexOfPrimes[i]] * primes[i]) {
                    indexOfPrimes[i]++;                                   // 注意这种存储坐标的用法。加加可以指向下一个因数而不是加一
                }
            }
            superUglyNumbers[count] = min;
            count++;
        }
        return superUglyNumbers[n - 1];
    }
}
