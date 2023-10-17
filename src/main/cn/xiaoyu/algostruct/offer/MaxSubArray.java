package xiaoyu.algostruct.offer;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">...</a>
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int acc = 0;
        for (int num : nums) {
            acc = acc <= 0 ? num : acc + num;
            sum = Math.max(sum, acc);
        }
        return sum;
    }
}
