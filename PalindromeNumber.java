/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
            
        if (x == 0) 
            return true;
            
        int sum = 0;
        int origin = x;
        
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum == origin;
    }
}
