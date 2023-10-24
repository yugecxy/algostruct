package xiaoyu.algostruct.tag.permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 */
public class PermutationsWithDistinct {
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new LinkedList<>(), new boolean[nums.length]);
        return ret;
    }

    public void dfs(int[] nums, List<Integer> current, boolean[] trace) {
        if (current.size() == nums.length) {
            ret.add(new LinkedList<>(current));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!trace[i] && !set.contains(nums[i])) {
                current.add(nums[i]);
                trace[i] = true;
                dfs(nums, current, trace);

                set.add(nums[i]);
                trace[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        PermutationsWithDistinct permutations = new PermutationsWithDistinct();
        permutations.dfs(nums, new LinkedList<>(), new boolean[3]);
        System.out.println(permutations.ret);
    }
}
