/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates[0] > target)
            return res;
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, 0, target);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int target) { // Note the start
        if (target == 0) {
            res.add(new ArrayList<Integer> (list));                                                             // New
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) { 
            list.add(candidates[i]);
            helper(res, list, candidates, i, target - candidates[i]);                                           // to avoid duplicates
            list.remove(list.size() - 1);                                                                       // Note the nontarget
        }
    }
}
