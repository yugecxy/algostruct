package xiaoyu.algostruct.offer.把数组排成最小的数;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/">...</a>
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        int count = 0;
        for (int num : nums) {
            strings[count++] = String.valueOf(num);
        }

        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        return String.join("", strings);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
