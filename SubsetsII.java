/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        res.add(list);
        helper (res, list, nums, 0);
        return res;
    }
    private void helper (List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<Integer> (list));
            helper (res, list, nums, i + 1);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1])                   // Note the location of this statement.
                i++;
        }
    }
}
