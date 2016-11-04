/*
Given a set of intervals, for each of the interval i, 
check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, 
which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, 
which means that the interval j has the minimum start point to build the "right" relationship for interval i. 
If the interval j doesn't exist, store -1 for the interval i. 
Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.

Example 1:
Input: [ [1,2] ]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:
Input: [ [3,4], [2,3], [1,2] ]
Output: [-1, 0, 1]
Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.

Example 3:
Input: [ [1,4], [2,3], [3,4] ]
Output: [-1, 2, -1]
Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 /*
 此题的题意是，为每个interval找到它右边（X.start >= interval.end）的interval X 的index, 并且这个X 的 start 最小。
 比如[4,5][0,1][2,3][7,8]. 返回[3,2,0,-1]. 第二个interval，返回的是[2,3]的index。
 用HashMap存每个interval的start, 和其index。
 存储完index再根据start排序。
 */
 
import java.util.*;
public class FindRightInterval {
	public class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public int[] findRightInterval(Interval[] intervals) {
		int[] res = new int[intervals.length];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			hm.put(intervals[i].start, i);
		}
		Arrays.sort(intervals, (a,b) -> (a.start - b.start));         // 闪闪的代码
		for (int i = 0; i < intervals.length; i++) {
			int target = intervals[i].end;
			int low = i + 1;
			int high = intervals.length;
			while (low < high) {
				int mid = (low + high) / 2;
				if (intervals[mid].start < target)                        // 不是属于右边的，由于按照start排序，所以mid之前的都不符合。
					low = mid + 1;
				else
					high = mid;                                             // 包含mid
			}
			res [hm.get(intervals[i].start)] = (high == intervals.length)? -1 : hm.get(intervals[high].start);
		}
		return res;
	}
}
