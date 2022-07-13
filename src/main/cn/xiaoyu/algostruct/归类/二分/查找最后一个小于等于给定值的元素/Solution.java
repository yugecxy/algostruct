package xiaoyu.algostruct.归类.二分.查找最后一个小于等于给定值的元素;

public class Solution {
    public int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return arr[mid];
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().binarySearch(
                new int[]{9, 10, 4, 3, 6, 14}, 8
        ));
    }
}
