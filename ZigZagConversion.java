/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int nRows) {
        
        if (s == null)
            return null;
        if (nRows == 1)
            return s;
            
        int step = 2 * nRows - 2;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j = j + step) {
                res.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + 2 * (nRows - i - 1) < s.length())
                    res.append(s.charAt(j + 2 * (nRows - i - 1)));
            }
        }
        return res.toString();
    }
}
