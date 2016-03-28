/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// 两层循环，第一层某一个点(x, y)，第二层每一个点与其形成的直线。hm存储<斜率，个数>。而还应考虑两个相同点的情况。
// 遍历其他点与(x, y)形成直线含点的个数，用localMax存储其他点与(x, y)形成直线中含的点最多的。
// 而localMax还需加入若干个(x, y)
// 最后res是全局的Max.

public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        int res = 1;                                                              // 最少一个
        if (points.length == 1)
            return res;

        for (int i = 0; i < points.length; i++) {                                 // 第一层循环，每一个点(x, y)
            HashMap<Float, Integer> hm = new HashMap<>();
            int same = 0;
            int localMax = 1;
            for (int j = 0; j < points.length; j++) {       
                if (i == j)                                                       // 忽略同一个坐标
                    continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;                                                       // 与(x, y)相同的点，计数
                    continue;
                }
                float slope = (float)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (hm.containsKey(slope))
                    hm.put(slope, hm.get(slope) + 1);
                else
                    hm.put(slope, 2);                                             // 两点形成的直线，所以最少为2
            }
            for (Integer value : hm.values())                           
                localMax = Math.max(localMax, value);                             // 用localMax存储与(x, y)连成的所有直线上最多的点
            localMax = localMax + same;
            res = Math.max(res, localMax);
        }
        return res;
    }
}
