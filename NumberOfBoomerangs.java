/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. 
You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/


import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[][] points = {{5,5}, {4,7}, {6,5}, {6,9}, {3,7}, {4,5}, {2,5}, {4,4}, {3,0}};
		System.out.println(new Solution().numberOfBoomerangs(points));
	}
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        if (points == null || points.length == 0 || points[0].length == 0)
            return res;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int d = distance(points[i], points[j]);
                if (!hm.containsKey(d)) {
                    hm.put(d, 1);
                }
                else {
                    hm.put(d, hm.get(d) + 1);
                }
                
            }
            for (int dis : hm.keySet()) {
                int n = hm.get(dis);
                if (n >= 2) {
                	res += (n - 1) * n;
                }
            }
        }
        return res;
    }
    public int distance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
