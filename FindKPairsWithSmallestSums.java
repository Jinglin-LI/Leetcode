/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
Return: [1,2],[1,4],[1,6]
The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
Return: [1,1],[1,1]
The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 
Return: [1,3],[2,3]
All possible pairs are returned from the sequence:
[1,3],[2,3]
*/
// Collections.sort(res, new Comparator<XX>()). 此题有更好的做法。

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int[] a = {nums1[i], nums2[j]};             //如果a[0] = nums1[i], a[1] = nums2[j], 再加入到res中，实际存放的是地址，所以更新完值之后是最后一次的值。
				res.add(a);
			}
		}
		Collections.sort(res, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return (o1[0] + o1[1]) - (o2[0] + o2[1]);
			}
		});
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < k && i < res.size(); i++) {
			result.add(res.get(i));
		}
		return result;
	}
}
