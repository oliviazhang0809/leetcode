public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (!set.contains(n) && n != 1) {
            set.add(n);
            n = helper(n);
        }
        return n == 1;
    }
    
    public int helper(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}