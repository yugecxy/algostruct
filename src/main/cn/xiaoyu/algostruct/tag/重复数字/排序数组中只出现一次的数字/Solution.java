package xiaoyu.algostruct.tag.重复数字.排序数组中只出现一次的数字;

/**
 * <a href="https://leetcode.cn/problems/skFtm2/">...</a>
 */
public class Solution {
    /**
     * 依次比较
     */
    public int singleNonDuplicate1(int[] nums) {
        int c = 0;
        for (int num : nums) {
            if (c == 0) {
                c = num;
            } else {
                if (num != c) {
                    return num;
                } else {
                    c = 0;
                }
            }
        }
        return c;
    }

    /**
     * 位运算(0异或A为A，A异或A为0)
     */
    public int singleNonDuplicate2(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}
