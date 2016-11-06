/*
There are a number of spherical balloons spread in two-dimensional space. 
For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. 
Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. 
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. 
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:
Input:
[[10,16], [2,8], [1,6], [7,12]]
Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) 
and another arrow at x = 11 (bursting the other two balloons).
*/

public class Solution {
     public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;
        int res = 1;
        Arrays.sort(points, new Comparator<Object>() {          // 注意二维数组按照第一位排序的方法。
        	public int compare(Object o1, Object o2) {
        		int[] one = (int[]) o1;
        		int[] two = (int[]) o2;
        		return one[0] - two[0];
        	}
        });
 
        Pair pair = new Pair(points[0][0], points[0][1]);
        for (int i = 1; i < points.length; i++) {
        	if (points[i][0] >= pair.left && points[i][0] <= pair.right) {
        		pair = new Pair(Math.max(pair.left, points[i][0]), Math.min(pair.right, points[i][1]));
 //       		System.out.println(pair.left + ", " + pair.right + "test 1");
        	}
        	else {
        		res++;
        		pair = new Pair(points[i][0], points[i][1]);
        	}
        }
        return res;
    }
    
    public class Pair {
    	int left;
    	int right;
    	Pair(int x, int y) {
    		left = x;
    		right = y;
    	}
    }
}
