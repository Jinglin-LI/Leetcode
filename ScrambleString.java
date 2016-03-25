/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 = "great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.
For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".
Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".
*/
/*
递归。s1分成两半，s11和s12. s2分两半，s21和s22. 
1) s11和s21判断isScramble. s12和s22判断
2）s11和s22判断，s12和s21判断。（注意s2需要重新split，因为长度不一样）
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if (s1.length() == 1 && s2.length() == 1)
            return s1.charAt(0) == s2.charAt(0);
        
        // 这一部分不明白。是为了过TLE准备的。
        char[] t1 = s1.toCharArray(), t2 = s2.toCharArray();          
        Arrays.sort(t1);
        Arrays.sort(t2);
        if (!new String(t1).equals(new String(t2)))
            return false;

        for (int split = 1; split < s1.length(); split++) {
            String s11 = s1.substring(0, split);
            String s12 = s1.substring(split);
            
            String s21 = s2.substring(0, split);
            String s22 = s2.substring(split);
            
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            
            s21 = s2.substring(0, s2.length() - split);
            s22 = s2.substring(s2.length() - split);
            
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }
        return false;
    }
}
