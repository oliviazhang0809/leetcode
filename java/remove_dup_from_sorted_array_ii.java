/**
 * when two dups are allow [not allow three]
 * 
 * @author oliviazhang
 * 
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length; 
        if (len <= 2) return len;
        int index = 2;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // index - 2 - the allowable range of dup
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}