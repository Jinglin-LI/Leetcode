/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

/*
在计算中位数Median时候，需要根据奇偶分类讨论。
解决此题的方法可以依照：寻找一个unioned sorted array中的第k大（从1开始数）的数。
因而等价于寻找并判断两个sorted array中第k/2（从1开始数）大的数。
特殊化到求median，那么对于奇数来说，就是求第(m+n)/2+1（从1开始数）大的数。
而对于偶数来说，就是求第(m+n)/2大（从1开始数）和第(m+n)/2+1大（从1开始数）的数的算术平均值。

那么如何判断两个有序数组A,B中第k大的数呢？
我们需要判断A[k/2-1]和B[k/2-1]的大小。
如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。
如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。
当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。
如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作就好。

当然，边界条件页不能少，需要判断是否有一个数组长度为0，以及k==1时候的情况。
因为除法是向下取整，并且也为了方便起见，对每个数组的分半操作采取：
int partA = Math.min(k/2,m);
int partB = k - partA; 
为了能保证上面的分半操作正确，需要保证A数组的长度小于B数组的长度。
同时，在返回结果时候，注意精度问题，返回double型的就好。 
*/

/* 问题等价于求两个array的第k=(m+n)/2大的数是多少。
   每次通过查看两个数组的第k/2大的数(假设是A[k/2],B[k/2])
   如果两个A[k/2]=B[k/2]，说明当前这个数即为两个数组剩余元素的第k大的数
   如果A[k/2]>B[k/2], 那么说明B的前k/2个元素都不是我们要的第k大的数，反之则排除A的前k/2个
   如此每次可以排除k/2个元素，最终k=1时即为结果。
   总的时间复杂度为O(logk),空间复杂度也是O(logk)，即为递归栈大小。
   在这个题目中因为k=(m+n)/2,所以复杂度是O(log(m+n))。
   
   有时候剩下的数不足k/2个，那么就得剩下的，而另一个数组则需要多取一些数。
   但是由于这种情况发生的时候，不是把一个数组全部读完，就是可以切除k/2个数，所以不会影响算法的复杂度。 
   这道题的优化算法主要是由order statistics派生而来，原型应该是求topK的算法
   这个问题是非常经典的问题，一般有两种解法，一种是用quick select(快速排序的subroutine),另一种是用heap。 
   
   参考：http://blog.csdn.net/linhuanmars/article/details/19905515
         http://www.cnblogs.com/springfor/p/3861890.html
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 1)
            return (double)findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);     // int 会取小，所以加一
        else {
            double x = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2);
            double y = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
            return (double)(x + y) / 2;
        }
    }
    private int findKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
        int m = aEnd - aStart + 1;
        int n = bEnd - bStart + 1;
        if (m > n)
            return findKth(B, bStart, bEnd, A, aStart, aEnd, k);
        if (m == 0)
            return B[k - 1];                                                             // index要向下取一
        if (k == 1)
            return Math.min(A[aStart], B[bStart]);
        
        int partA = Math.min(k / 2, m);                                                  // 如果剩下的不足k/2个
        int partB = k - partA;
        if (A[aStart + partA - 1] < B[bStart + partB - 1])
            return findKth(A, aStart + partA, aEnd, B, bStart, bEnd, k - partA);
        else if (A[aStart + partA - 1] > B[bStart + partB - 1])
            return findKth(A, aStart, aEnd, B, bStart + partB, bEnd, k - partB);
        else 
            return A[aStart + partA - 1];
    }
}
