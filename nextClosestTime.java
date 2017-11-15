/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid. 

Example1: 
Input:"19:34"
Output:"19:39"
Explanation: The next closest time choosing from digits 1,9,3,4 is 19:39, which occurs 5 minutes later. 
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example2:
Input:"23:59"
Output:"22:22"
Explanation: The next closest time choosing from digits 2,3,5,9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically. 
*/

import java.util.HashSet;
import java.util.Set;

public class nextClosestTime {
	
	public static void main(String[] args) {
		nextClosestTime test = new nextClosestTime();
		System.out.println(test.next("23:59"));
	}
	
	public String next(String time) {
		String[] input = time.split(":");
		Set<Integer> hs = new HashSet<>();
		hs.add(Integer.parseInt(input[0].substring(0, 1)));
		hs.add(Integer.parseInt(input[0].substring(1, 2)));
		hs.add(Integer.parseInt(input[1].substring(0, 1)));
		hs.add(Integer.parseInt(input[1].substring(1, 2)));
		
		Set<Integer> possible = new HashSet<>();
		int minValue = Integer.MAX_VALUE;
		for (int i : hs) {
			for (int j : hs) {
				int temp = i * 10 + j;
				possible.add(temp);
				minValue = Math.min(minValue, temp);
			}
		}
		
		String minTime;
		if (minValue < 10) {
			minTime = "0" + minValue;
		}
		else {
			minTime = minValue + "";
		}
		
		
		int minute = Integer.parseInt(input[1]);
		int hour = Integer.parseInt(input[0]);
		String res = "";
		
		if (minute < 59) {
			int tempMin = Integer.MAX_VALUE;
			for (int i : possible) {
				if (i > minute && i < 60) {
					tempMin = Math.min(tempMin, i);
				}
			}
			
			if (tempMin != Integer.MAX_VALUE) {
				if (tempMin < 10) {
					res += input[0] + ":0" + tempMin;
				}
				else {
					res += input[0] + ":" + tempMin;
				}
				return res;
			}
		}
		
		if (hour < 23) {
			int tempMin = Integer.MAX_VALUE;
			for (int i : possible) {
				if (i > hour && i < 24) {
					tempMin = Math.min(tempMin, i);
				}
			}
			
			if (tempMin != Integer.MAX_VALUE) {
				if (tempMin < 10) {
					res += "0" + tempMin + ":" + minTime;
				}
				else {
					res += tempMin + ":" + minTime;
				}
				return res;
			}
		}
		res += minTime + ":" + minTime;
		return res;
	}
}
