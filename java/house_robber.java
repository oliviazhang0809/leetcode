public class Solution {
    public int rob(int[] nums) {
        int today = 0, yesterday = 0, be4yesterday = 0;
        for (int i = 0; i < nums.length; i++) {
            today = Math.max(nums[i] + be4yesterday, yesterday); // whether to rob today
            be4yesterday = yesterday;
            yesterday = today;
        }
        return today;
    }
}
