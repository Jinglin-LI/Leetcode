/*
The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/
/*
归纳法。n位数的话，除去最高位，剩下的n-1位有（n - 1）!种排列。
利用 k/(n-1)!可以获得最高位在ArrayList中的index. 则第k个排列的最高位能从ArrayList中index位取得。
用完后将此数从数列中删除。则剩下的数字移动，不再对应相同的index.即再取就先取剩下的最小的数。
k变成k%(n-1)!, 循环n次。每一次记得把(n-1)!变成(n-2)!.
为了跟数组坐标一致，k--;
此时还要把这个数从数列中删除。
*/

public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> numsList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            numsList.add(i);
        int factorial = 1;
        for (int i = 2; i <= n - 1; i++) 
            factorial = factorial * i;
        
        StringBuilder sb = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            int indexInList = k / factorial;
            sb.append(numsList.get(indexInList));
            numsList.remove(indexInList);
            
            k = k % factorial;
            if (times != 0)
                factorial = factorial / times;
            times--;
        }
        return sb.toString();
    }
}
