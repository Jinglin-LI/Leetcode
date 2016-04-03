/*
You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:
Given nums = [5, 2, 6, 1]
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/
/*
Reference: https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code
从右到左nums[i]加入到新的有序数组中。新的数所要插入的位置即为它右边小于它的个数。用BST。
*/

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            res[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    
    private int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0)
            return 0;
        int low = 0, high = sorted.size() - 1;
        if (sorted.get(high) < target)
            return high + 1;
        if (sorted.get(low) >= target)
            return 0;  
        while (low  + 1 < high) {
            int mid = (low + high) / 2;
            if (sorted.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        if (sorted.get(low) >= target)
            return low;
        return high;
    }
}
