public class Solution { // many edge cases, very annoying 
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char flag = '+';
        int index = 0;
        str = str.trim();
        if (str.charAt(index) == '-') {
            flag = '-';
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        double res = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            res = res * 10 + str.charAt(index) - '0';
            index++;
        }
        if (flag == '-') res = -res;
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int)res;
    }
}