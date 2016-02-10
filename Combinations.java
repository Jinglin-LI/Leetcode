/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k)
            return res;
        List<Integer> list = new ArrayList<>();
        helper(res, list, 1, n, k);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, i + 1, n, k);                        // Note the usage of i + 1. Find the next behind current element.
            list.remove(list.size() - 1);
        }
    }
}
