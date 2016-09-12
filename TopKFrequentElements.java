/*
Given a non-empty array of integers, return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
// 用HashMap和Heap(PriorityQueue)做，原题目很多人用木桶排序法（Bucket Sort）, 以后可以试一下。
// 本题注意comparator排序的用法。hm.get(o1)的比较。

import java.util.*;
public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,4};
		System.out.println(new TopKFrequentElements().topKFrequent(nums, 2));
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int num : nums) {
			if (!hm.containsKey(num))
				hm.put(num, 1);
			else
				hm.put(num, hm.get(num) + 1);
		}
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return hm.get(o1) - hm.get(o2);                                   // 注意comparator用法，注意hm.get(o1)的用法
			}
		});
		for (Integer key : hm.keySet()) {                                     // 注意遍历hm.keySet()的用法
			pq.add(key);
			if (pq.size() > k)                                                  // 大于k, 就把（k+1）个数中最小的poll掉。
				pq.poll();
		}
		for (int i = 0; i < k; i++) {
			res.add(pq.poll());         
		}
		return res;
	}
}
