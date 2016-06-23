/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		int[] ans = new TwoSum().twoSum2(numbers, target);
		System.out.print("[" + ans[0] + "," + ans[1] + "]");
	}
	// O(n2)
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		throw new IllegalArgumentException("No such two numbers");
	}
	// O(log n)
	public int[] twoSum2(int[] numbers, int target) {
		int[] res = new int[2];
		Map <Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (hm.containsKey(target - numbers[i])) {
				res[0] = hm.get(target - numbers[i]);
				res[1] = i;
				return res;
			}
			hm.put(numbers[i],i);
		}
		throw new IllegalArgumentException("No such two numbers by the twoSum2");
	}
}
