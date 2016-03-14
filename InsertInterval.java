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
