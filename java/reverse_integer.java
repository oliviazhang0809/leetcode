public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int next = res * 10 + x % 10;
            if ((next - x % 10) / 10 != res) { // check if overflow -- if over flow just return 0;
                return 0;
            }
            res = next;
            x /= 10;
        }
        return res;
    }
}