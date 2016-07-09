/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        if (end < start)
            return null;
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(arr[middle]);
        node.left = sortedArrayToBST(arr, start, middle - 1);
        node.right = sortedArrayToBST(arr, middle + 1, end);
        return node;
    }
    
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] leftOfNums = Arrays.copyOfRange(nums, 0, mid);
        int[] rightOfNums = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.left = sortedArrayToBST(leftOfNums);
        root.right = sortedArrayToBST(rightOfNums);
        return root;
    }
}
