package xiaoyu.algostruct.offer.___和为s的两个数字;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/">...</a>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];

            if (leftVal + rightVal == target) {
                return new int[]{leftVal, rightVal};
            } else if (leftVal + rightVal > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{-1, 1, 2, 4, 4, 8, 9}, 3)));
    }
}
