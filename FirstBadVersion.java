/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low / 2 + high / 2;         // (low + high) / 2 may cause Time Limit Exceeded (TLE), because of overflow.
            if (!isBadVersion(mid)) {
                low = mid + 1;
            }
            if (isBadVersion(mid)) {
                high = mid;
            }
        }
        if (low == high)
            return low;
        return 0;
    }
}



/*=========================================================================================================*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1){
            return 0;
        }
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid)){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}

