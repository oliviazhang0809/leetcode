public class Solution {
    public boolean isPalindrome(int x) {
        int rev = reverse(x);
        return rev == x;
    }
    
    public int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}