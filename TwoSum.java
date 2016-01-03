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
