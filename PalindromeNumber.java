/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
            
        if (x == 0) 
            return true;
        
        int base = 1;  
        
        while (x / base >= 10) 
            base = base * 10;
            
        while (x != 0) {
            if (x % 10 == x / base) {        // compare the last and the first digit
                x = (x % base) / 10;         // remove the last and the first digit
                base = base / 100;
            }
            
            else
                return false;
            }
            
        return true;
    }
}
