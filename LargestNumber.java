/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s2.compareTo(s1);
            }
        };
        
        Collections.sort(list, comp);
        
        StringBuilder res = new StringBuilder();
        for (int i : list) {
            res.append(i);
        }
        if (res.charAt(0) == '0')                                     // note the usage of charAt(0) == '0';
            return "0";
        return res.toString();
    }
}
