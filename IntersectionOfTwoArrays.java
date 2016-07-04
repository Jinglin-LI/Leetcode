import java.util.*;
public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] num1 = {1,2,3,4,5};
		int[] num2 = {2,3,4};
		int[] res = new IntersectionOfTwoArrays().intersection(num1, num2);
		System.out.println(res[0] + ", " + res[1] + ", " + res[2]);
	}
	public int[] intersection(int[] nums1, int[] nums2) {
		
		HashSet<Integer> hs = new HashSet<>();
		if (nums1 == null || nums2 == null)
			return null;
		for (Integer i : nums1) {
			if (!hs.contains(i))
				hs.add(i);
		}
		List<Integer> list = new ArrayList<>();
		for (Integer i : nums2) {
			if (hs.contains(i) && !list.contains(i))
				list.add(i);
		}
		int size = list.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
