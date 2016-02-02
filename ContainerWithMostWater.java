/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        int low = 0; 
        int high = height.length - 1;
        int area = 0;
        while (low < high) {
            area = Math.max(area, Math.min(height[high], height[low]) * (high - low));
            if (height[low] <= height[high])
                low++;
            else
                high--;
        }
        return area;
    }
}
