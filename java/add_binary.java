/**
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int max = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int p = 0;
            int q = 0;
            if (i < a.length()) {
                p = a.charAt(a.length() - 1 - i) - '0';
            } else {
                p = 0;
            }
            if (i < b.length()) {
                q = b.charAt(b.length() - 1 - i) - '0';
            } else {
                q = 0;
            }
            int tmp = p + q + carry;
            carry = tmp / 2;
            sb.append(tmp % 2);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
        
    }
}