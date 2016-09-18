/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
// 思维要转换一下：Intervals中每一个元素与newInterval进行比较。
// 加入新的list中。Intervals中每一个元素的end和新元素的start比较，小的话，每一个元素加入新list。
// 同理，每一个元素start和新元素end比较，大的话，每一个元素加入新的list.
// 其他情况就要merge。每一次旧的元素入list,更改newInterval. 

import java.util.*;
public class InsertInterval {
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
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		for (Interval each : intervals) {
			if (each.end < newInterval.start)
				res.add(each);
			else if (each.start > newInterval.end) {
				res.add(newInterval);
				newInterval = each;
			}
			else if (each.end >= newInterval.start || each.start <= newInterval.end) {
				newInterval = new Interval(Math.min(each.start, newInterval.start), Math.max(newInterval.end, each.end));
			}
		}
		res.add(newInterval);
		return res;
	}
}


public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null) {
        	res.add(newInterval);
        	return res;
        }                                                               // this part seems to be considered later. 
        if (newInterval == null)
        	return intervals;
        
        intervals.add(newInterval);                                     // merge intervals with newInterval
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval a = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval b = intervals.get(i);
            if (b.start <= a.end) {
                Interval temp = new Interval();
                temp.start = Math.min(b.start, a.start);
                temp.end = Math.max(b.end, a.end);
                a = temp;
            }
            else {
                res.add(a);
                a = b;
            }
        }
        res.add(a);
        return res;
    }
}
