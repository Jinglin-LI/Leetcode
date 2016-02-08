/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
/*
从第一位不是倒序的数字看起，与其后面找出大于它的数字交换，它之后的数字正序排列。
*/

public class Solution {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;
        int i = len - 2;
        if (nums[i] < nums[i + 1]) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
            return;
        }
        for (i = i - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        if (i == -1) {
            Arrays.sort(nums);
            return;
        }
        int k = len - 1;
        for (k = len - 1; k > i; k--) {
            if (nums[i] < nums[k])
                break;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
        Arrays.sort(nums, i + 1, len);                              // Note the usage of len, but not len - 1
    }
}
