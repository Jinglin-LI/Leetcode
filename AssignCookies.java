/*
Assume you are an awesome parent and want to give your children some cookies. 
But, you should give each child at most one cookie. 
Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; 
and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. 
Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.

Example 1:
Input: [1,2,3], [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

Example 2:
Input: [1,2], [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
*/

// 此题的题干是，有几个饼干（不同大小）给几个孩子，每个对大小有满意度。问怎么给能满足最多的孩子。

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g == null || g.length == 0 || s == null || s.length == 0)
            return res;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            while (i < g.length && j < s.length && s[j] >= g[i]) {
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}
