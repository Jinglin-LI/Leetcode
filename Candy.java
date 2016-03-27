/*
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
/*
本题的意思是！每相邻两个小盆友，排名高的，拿到的糖果多一个（跟另一个比）
例子： input:   3 4 5 4 3                     or    1 2 3 5 4 6 2（即1与2比，2与3比，3与5比...）
       output:  1 2 3 2 1                           1 2 3 4 1 2 1
设想一下，如果先把output中每一个元素设为1，遍历ratings,大的排名则output相应位置加一。则最后若是降序结尾，后面的降序都为1。（错！）
所以可将output想象成波峰波谷，波谷为1.剩下的元素随ratings上坡下坡。
当index的值与其左边和右边的元素都相关时，考虑左向右、右向左扫描。leftNums和rightNums都是最少要满足的条件，所以最后用max求两者最大。
*/

public class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        if(ratings == null || ratings.length == 0)
            return res;
        int[] leftNums = new int[ratings.length];
        int[] rightNums = new int[ratings.length]; 
        leftNums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                leftNums[i] = leftNums[i - 1] + 1;
            else
                leftNums[i] = 1;
        }
        
        rightNums[ratings.length - 1] = leftNums[ratings.length - 1];               // note this statement
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                rightNums[i] = rightNums[i + 1] + 1;
            else
                rightNums[i] = 1;
        }
        
        for (int i = 0; i < ratings.length; i++)
            res += Math.max(leftNums[i], rightNums[i]);
        return res;
    }
}
