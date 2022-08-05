package xiaoyu.algostruct.offer.调整数组顺序使奇数在前;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">...</a>
 */
public class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{2, 6, 3, 9, 10, 12})));
    }
}
