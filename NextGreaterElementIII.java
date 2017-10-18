/*
Given a positive 32-bit integer n, 
you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21
Example 2:
Input: 21
Output: -1
*/

import java.util.Arrays;

// 从右向左找第一个不符合升序的数，位置记为index, 如果index 为-1， 返回-1
// 从右向index找第一个比他大的数，交换index位置的数和这个比他大的数
// 从index+1到末尾进行生序排列

public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
		char[] array = (n + "").toCharArray();
		int index = array.length - 2;
		while (index >= 0) {
			if (array[index] >= array[index + 1]) {
				index--;
			}
			else {
				break;
			}
		}
		
		if (index == -1) {
			return -1;
		}
		else {
			int j = array.length - 1;
			while (array[j] <= array[index]) {
				j--;
			}
			char temp = array[j];
			array[j] = array[index];
			array[index] = temp;
			Arrays.sort(array, index + 1, array.length);
		}
		long res = Long.parseLong(new String(array));  	// 防止integer的溢出
		return res > Integer.MAX_VALUE? -1 : (int)res;
	}
}
