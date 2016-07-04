/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
    }
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

public class NumArray2 {
    private int[] sums;
    public NumArray(int[] nums) {
        if (nums.length != 0){                      // 不然sum[0] = nums[0]那一步会报错
            sums = new int[nums.length];
        
            sums[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                sums[i] = nums[i] + sums[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i==0 ? sums[j] : sums[j]-sums[i-1];
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
