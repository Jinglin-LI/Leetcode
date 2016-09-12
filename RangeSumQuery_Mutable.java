/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly
*/

public class RangeSumQuery_Mutable {
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;
		public SegmentTreeNode(int s, int e) {
			start = s;
			end = e;	
		}
	}
	public class NumArray {
		SegmentTreeNode root;
		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			root = buildTree(nums, 0, nums.length - 1);
		}
		public SegmentTreeNode buildTree(int[] nums, int left, int right) {
			SegmentTreeNode root = new SegmentTreeNode(left, right);
			if (left == right) {
				root.sum = nums[left];
			}
			else {
				int mid = (left + right) / 2;
				root.left = buildTree(nums, left, mid);
				root.right = buildTree(nums, mid + 1, right);
				root.sum = root.left.sum + root.right.sum;
			}
			return root;
		}
		
		void update(int i, int val) {
			update(root, i, val);
		}
		void update(SegmentTreeNode root, int i, int val) {
			if (root.start == root.end)
				root.sum = val;
			else {
				int mid = (root.start + root.end) / 2;
				if (i <= mid)
					update(root.left, i, val);
				else
					update(root.right, i, val);
				root.sum = root.left.sum + root.right.sum;
			}
		}
		public int sumRange(int i, int j) {
			return sumRange(root, i, j);
		}
		private int sumRange(SegmentTreeNode root, int start, int end) {
			if (root.start == start && root.end == end)
				return root.sum;
			else {
				int mid = (root.start + root.end) / 2;
				if (end <= mid)
					return sumRange(root.left, start, end);
				else if (start > mid)
					return sumRange(root.right, start, end);
				return sumRange(root.left, start, root.left.end) + sumRange(root.right, root.right.start, end);
			}
		}
	}
}
