//https://leetcode.com/problems/maximum-product-subarray/
public class Solution {
    public int maxProduct(int[] nums) {
        int maxsofar = nums[0];
        int maxherepre = nums[0];
        int minherepre = nums[0]; // need to maintain both max and min, in case [-1, 2, -3] -> 6
        int maxhere, minhere;
        
        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxsofar, maxhere);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }
}