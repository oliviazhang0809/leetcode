//Reverse bits of a given 32 bits unsigned integer.

//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>= 1;
            if (i != 31) res <<= 1; // no need to shift last digit
        }
        return res;
    }
}