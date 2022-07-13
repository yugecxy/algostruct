package xiaoyu.algostruct.归类.二分.搜索旋转排序数组;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">...</a>
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[0]) { //应该在左边找
                if (nums[mid] < nums[0] || nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  //应该在右边找
                if (nums[mid] >= nums[0] || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 1, 1};
        System.out.println(new Solution().search(arr, 1));
    }
}
