/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1)
            return res;
        
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "");
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");
        
        String str = "";
        helper(digits, res, str, hm, 0);
        return res;
    }
    
    private void helper(List<String> res, Map<Integer, String> hm, String digits, String str, int index) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }
        int target = digits.charAt(index) - '0';
        for (int i = 0; i < hm.get(target).length(); i++) {
            String newStr = str + hm.get(target).charAt(i);
            helper(res, hm, digits, newStr, index + 1);
        }
    }
}
