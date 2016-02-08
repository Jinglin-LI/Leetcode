/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target)
            return res;
        helper(res, candidates, target, 0, new ArrayList<Integer>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] candidates, int target, int start, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<Integer> (list));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, candidates, target - candidates[i], i + 1, list);                                   // Note the i + 1
            list.remove(list.size() - 1);
            
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                i++;
        }
    }
}
