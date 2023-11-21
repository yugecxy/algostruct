package xiaoyu.algostruct.offer;

/**
 * <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">...</a>
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                pivot++;
                int tmp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
