package xiaoyu.algostruct.tag.permutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 */
public class Permutations {
    public List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
//        dfs(nums, new LinkedList<>());
        dfs(nums, new Integer[nums.length], 0, new boolean[nums.length]);
        return ret;
    }

    public void dfs(int[] nums, List<Integer> current, boolean[] trace) {
        if (current.size() == nums.length) {
            ret.add(new LinkedList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!trace[i]) {
                current.add(nums[i]);
                trace[i] = true;
                dfs(nums, current, trace);
                trace[i] = false;
                current.remove(current.size() - 1);
            }
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
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        permutations.dfs(nums, new LinkedList<>(), new boolean[3]);
        System.out.println(permutations.ret);
    }
}
