package xiaoyu.algostruct.归类.排列组合.全排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 */
public class Solution {
    public List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
//        dfs(nums, new LinkedList<>());
        dfs(nums, new Integer[nums.length], 0, new boolean[nums.length]);
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

    public void dfs(int[] nums, Integer[] current, int pos, boolean[] trace) {
        if (pos == nums.length) {
            ret.add(new LinkedList<>(Arrays.asList(current)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!trace[i]) {
                current[pos] = nums[i];
                trace[i] = true;
                dfs(nums, current, pos + 1, trace);
                trace[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list1 = new Solution().permute(nums);
        System.out.println(1111);
    }
}
