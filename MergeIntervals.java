/*
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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

// 根据start元素排序。从第二个intervals的start和第一个intervals的end相比较。不用merge则转移到下一个intervals.

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        Interval a = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval b = intervals.get(i);
            if (a.end >= b.start) {
                a = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
            }
            else {
                res.add(a);
                a = b;                                              // a has been stored. Then a points to the next intervals
            }
        }
        res.add(a);
        return res;
    }
}
