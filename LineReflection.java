/*
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
*/

// 用hashmap, key存x, y存同一个x不同的y.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		if (points == null) {
			return false;
		}
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		Map<Integer, Set<Integer>> hm = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			minX = Math.min(minX, points[i][0]);
			maxX = Math.max(maxX, points[i][0]);
			if (!hm.containsKey(points[i][0])) {
				hm.put(points[i][0], new HashSet<>());
			}
			hm.get(points[i][0]).add(points[i][1]);
		}
		
		double mid = (minX + maxX) / 2.0;
		for (int i = 0; i < points.length; i++) {
			int key = (int)(2 * mid - points[i][0]);
			if (!hm.containsKey(key) || !hm.get(key).contains(points[i][1])) {
				return false;
			}
		}
		return true;
	}
}
