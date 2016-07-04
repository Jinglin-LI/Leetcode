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
