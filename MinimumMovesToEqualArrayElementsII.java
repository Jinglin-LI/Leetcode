/*
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, 
where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
You may assume the array's length is at most 10,000.

Example:
Input:
[1,2,3]
Output:
2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/

// 和 I 比，可加可减。最终变成中间的位置。

public class Solution {
    public int minMoves2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
}
