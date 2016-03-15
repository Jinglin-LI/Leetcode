/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/
// 把Interval[] 按照start排序。用最小堆存储每一个intervals的end. 
// 当最小堆peek的end，小于下一个intervals的start，则不用res++.这时poll它，下一个intervals的end存进去。

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
	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int res = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (pq.size() == 0) {
				pq.add(intervals[i].end);
				res++;
				continue;
			}
			if (pq.peek() <= intervals[i].start) {
				pq.poll();
				pq.add(intervals[i].end);
			}
			else {
				pq.add(intervals[i].end);
				res++;
			}
		}
		return res;
	}
}
