package xiaoyu.algostruct.tag.binarysearch.缺失的数字;

/**
 * <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/">...</a>
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    r = r - 1;
                }
            } else {
                if (mid == nums.length - 1) {
                    return mid + 1;
                }
                l += 1;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0}));
    }
}
