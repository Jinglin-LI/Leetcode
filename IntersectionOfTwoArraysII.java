/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, 
and the memory is limited such that you cannot load all elements into the memory at once?
*/

import java.util.*;
public class IntersectionOfTwoArraysII {
	public static void main(String[] args) {
		int[] num1 = {1};
		int[] num2 = {1,1};
		int[] res = new IntersectionOfTwoArraysII().intersect(num1, num2);
		System.out.println(res[0] + ", " + res[1]);
	}
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (Integer i : nums1) {
			if (!hm.containsKey(i))
				hm.put(i, 1);
			else
				hm.put(i, hm.get(i) + 1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer i : nums2) {
			if (hm.containsKey(i) && hm.get(i) != 0) {
				list.add(i);
				hm.put(i, hm.get(i) - 1);
			}
		}
		int size = list.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
