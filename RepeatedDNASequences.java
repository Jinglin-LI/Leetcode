/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
For example,
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
// 把A，T，C，G用00，01，10，11代替。添加一个字符，则原code向左移动两位再加上新数字。每次得到的20位的数字，check其是否在hm中个数为1. 
// 然而11个'C'的情况也能得到10个'C'.也许是这个题目的要求吧。。。

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String subStr = s.substring(i - 10, i);
            int code = encode(subStr);
            if (hm.containsKey(code)) {
                if (hm.get(code) == 1)                  // 只有一个返回，重复了的不用返回
                    res.add(subStr);
                hm.put(code, 2);
            }
            else
                hm.put(code, 1);
        }
        return res;
    }
    private int encode(String str) {
        int code = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            code = code << 2;                             // 准备加入新的字符
            switch(c) {
                case 'A': 
                    code += 0;
                    break;
                case 'C':
                    code += 1;
                    break;
                case 'T':
                    code += 2;
                    break;
                case 'G':
                    code += 3;
                    break;
            }
        }
        return code;
    }
}
