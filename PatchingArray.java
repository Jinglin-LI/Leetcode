/*
Given a sorted positive integer array nums and an integer n, 
add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. 
Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
*/
/*
假设我们需要填补的数字rangeExclusive
假设前面能包含的数字有[0, rangeExclusive),填上rangeExclusive之后，即变成[0, 2 * rangeExclusive) （因为不可重复所以不包含）
而rangeExclusive怎么求呢？假定初始化时nums[]为空，rangeExclusive则为1。
遍历nums[], 前面数字所获得的最大的range即存在rangeExclusive中
例如：          nums[]:       1 2 3 8
        rangeExclusive:     1 2 4 7 15 (即不包含的数)
那么当nums[i] > rangeExclusive时候，即res要计数加一了。然后假定加上了那个数，（假设nums[]中加入了那个数），所以 2 * rangeExclusive
*/

public class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        long rangeExclusive = 1;
        int i = 0;
        while (rangeExclusive <= n) {
            if (i < nums.length && nums[i] <= rangeExclusive) {
                rangeExclusive += nums[i];
                i++;
            }
            else {
                rangeExclusive += rangeExclusive;
                res++;
            }
        }
        return res;
    }
}
