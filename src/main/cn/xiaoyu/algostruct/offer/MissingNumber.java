package xiaoyu.algostruct.offer;

/**
 * <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/">...</a>
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
