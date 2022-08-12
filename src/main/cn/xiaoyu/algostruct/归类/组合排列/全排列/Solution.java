package xiaoyu.algostruct.归类.组合排列.全排列;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 */
public class Solution {
    public List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new LinkedList<>());
        return ret;
    }

    public void dfs(int[] nums, List<Integer> trace) {
        if (trace.size() >= nums.length) {
            ret.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                continue;
            }
            trace.add(nums[i]);

            int tmp = nums[i];
            nums[i] = Integer.MIN_VALUE;
            dfs(nums, trace);
            nums[i] = tmp;

            trace.remove(trace.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list1 = new Solution().permute(nums);
        System.out.println(1111);
    }
}
