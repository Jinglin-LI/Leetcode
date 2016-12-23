/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
*/

// 方法2和方法3是一样滴，都比方法1要好。
// Reference: http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

public class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            if (nums[i] == 1)
                count1++;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < count0; i++)
            res[i] = 0;
        for (int i = count0; i < (count0 + count1); i++)
            res[i] = 1;
        for (int i = (count0 + count1); i < nums.length; i++)
            res[i] = 2;
            
        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
    
/*=========方法2与方法3是一样滴。=============================================================================*/
	
    public void sortColors2(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int startIndex = 0, endIndex = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == 0 && i != startIndex) {
				int temp = nums[startIndex];
				nums[startIndex++] = nums[i];
				nums[i] = temp;
			}
			else if (nums[i] == 2 && i < endIndex) {
				int temp = nums[i];
				nums[i] = nums[endIndex];
				nums[endIndex--] = temp;
			}
			else {
				i++;
			}
		}
	}
	
}

/*=========== 方法3 ============================================================================*/

/* maintain 3 pointers, move mid pointer all the time
when meet with "Mid", mid++, 
when "Low", swap(low, mid), low++, mid++
when "High", swap(mid, high), high--
*/
public class SortColors {
	public void sortColors(int[] a) {
		int len = a.length;
		int low = 0;
		int high = len - 1;
		int mid = 0;
		while (mid <= high) {
			switch(a[mid]) {
				case 0: {
					swap(a, low, mid);
					low++;
					mid++;
					break;
				}
				case 1: {
					mid++;
					break;
				}
				case 2: {
					swap(a, mid, high);
					high--;
					break;
				}
			}
		}
	}
	public void swap(int[] a, int low, int mid) {
		int temp = a[low];
		a[low] = a[mid];
		a[mid] = temp;
	}
}
