package xiaoyu.algostruct.offer;

public class SearchInMatrix {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int pivotV = nums[end];
        while (begin <= end) {
            int middle = begin + ((end - begin) >> 1);
            if (nums[middle] == target) {
                return target;
            }
            //左边找
            if (target > pivotV) {
                if (nums[middle] > target || nums[middle] <= pivotV) {
                    end = middle - 1;
                } else {
                    begin = middle + 1;
                }
            } else {
                if (nums[middle] < target || nums[middle] > pivotV) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        System.out.println(new SearchInMatrix().search(nums, 0));
    }
}
