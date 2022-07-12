package xiaoyu.algostruct.归类.数组.最大子数组和;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">...</a>
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum = curSum < 0 ? num : curSum + num;
            max = Math.max(curSum, max);
        }
        return max;
    }
}
