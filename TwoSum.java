/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target-nums[j]) {
                    i++;
                    j++;
 //                 System.out.println("index1=" + i + ", index2=" + j);
                    a[0] = i;
                    a[1] = j;
                    return a;
            }
        }
    }
    throw new IllegalArgumentException ("No two sum solution");
}
}
