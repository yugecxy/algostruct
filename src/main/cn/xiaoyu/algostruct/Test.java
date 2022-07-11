package xiaoyu.algostruct;

public class Test {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //交换
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Test().findRepeatNumber(new int[]{1, 4, 3, 0, 5, 2, 3}));
    }
}
