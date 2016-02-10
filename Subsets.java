/*
Given a set of distinct integers, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) 
            return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        res.add(list);                                                  // Add "" in the res
        helper (res, list, nums, 0);
        return res;
    }
    private void helper (List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<Integer> (list));                     // Note the usage of this line. include all list length
            helper (res, list, nums, i + 1);
            list.remove (list.size() - 1);
        }
    }
}
