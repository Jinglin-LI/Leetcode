/*
Given a sorted integer array without duplicates, return the summary of its ranges.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

import java.util.*;

public class Solution {
	  public static void main(String[] args) {
		  int[] n = {-1};
		  System.out.println(new Solution().summaryRanges(n));
	  }
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null)
            return res;
        if (nums.length == 1) {
        	res.add(nums[0] + "");
        	return res;
        }
        int i = 0;
        int j = i + 1;
        int gap = 1;
        while (j < nums.length) {
            if (nums[i] + gap != nums[j]) {
                res.add("" + nums[i]);
                j++;
                i++;
            }
            else {
                j++;
                gap++;
                if (j < nums.length && nums[i] + gap != nums[j]) {
                    res.add(nums[i] + "->" + nums[j - 1]);
                    i = j;
                    j = i + 1;
                    gap = 1;
                }
            }       
        }
        if (j == nums.length && i == nums.length - 1)
        	res.add(nums[i] + "");
        if (j == nums.length && i < nums.length - 1)
            res.add(nums[i] + "->" + nums[j - 1]);
            
        return res;
    }
    
    // The second method
    public List<String> summaryRanges2(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (j < nums.length - 1 && nums[j] + 1 == nums[j + 1])
				j++;
			else {
				if (i == j)
					res.add(nums[i] + "");
				else {
					String str = nums[i] + "->" + nums[j];
					res.add(str);
				}
				j++;
				i = j;
			}
		}
		return res;
	}
}
