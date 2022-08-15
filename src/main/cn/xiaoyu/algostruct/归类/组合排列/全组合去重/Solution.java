package xiaoyu.algostruct.归类.组合排列.全组合去重;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> getAllSubSet(int[] nums) {
        dfs(nums, new LinkedList<>(), 0);
        return ret;
    }

    public void dfs(int nums[], List<Integer> trace, int step) {
        if (step >= nums.length) {
            ret.add(new LinkedList<>(trace));
            return;
        }
        dfs(nums, trace, step + 1);

        trace.add(nums[step]);
        dfs(nums, trace, step + 1);
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ret = new Solution().getAllSubSet(nums);
        System.out.println(111);
    }
}
