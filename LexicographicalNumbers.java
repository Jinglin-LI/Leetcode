/*
Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
// 此题可以用DFS完成。1-9遍历, (乘以10之后)，每一个数右边又从0-9选择。
// 用PQ没有DFS效率高，比较器写起来比较麻烦。因为1排在10前。

import java.util.*;
public class LexicographicalNumbers {
	public static void main(String[] args) {
		System.out.println(new LexicographicalNumbers().lexicalOrder(10));
	}
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			dfs(res, i, n);
		}
		return res;
	}
	private void dfs(List<Integer>res, int prefix, int n) {
		if (prefix > n)
			return;
		res.add(prefix);
		int temp = prefix * 10;
		for (int i = 0; i < 10; i++) {
			dfs(res, temp + i, n);
		}
	}
}
