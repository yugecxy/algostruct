package xiaoyu.algostruct.归类.二分.缺失的数字;

/**
 * <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/">...</a>
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
