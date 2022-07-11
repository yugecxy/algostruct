package xiaoyu.algostruct.归类.重复数字.数组中重复的数字;

import xiaoyu.algostruct.Test;

/**
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //交换
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Test().findRepeatNumber(new int[]{1, 4, 3, 0, 5, 2, 3}));
    }
}
