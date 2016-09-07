/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i : nums)
            q.add(i);
        for (int i = 0; i < k - 1; i++)
            q.poll();
        return q.peek();
    }
}

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
		return quickSelect2(nums, 0, nums.length - 1, k - 1);               // 第0个index里面存的最大的数儿。
	}
	private int quickSelect2(int[] nums, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = nums[(left + right) / 2];
		while (left <= right) {
			while (nums[left] > pivot)
				left++;
			while (nums[right] < pivot)
				right--;
			if (left <= right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		if (right > start && k <= right)                    // QuickSort 里面比较的是（right > start）.
			return quickSelect2(nums, start, right, k);
		if (left < end && k >= left)
			return quickSelect2(nums, left, end, k);
		return nums[k];
	}
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
