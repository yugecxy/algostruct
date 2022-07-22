package xiaoyu.algostruct;

import java.util.LinkedList;
import java.util.List;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {
    private List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode node, int target) {
        List<Integer> curList = new LinkedList<>();
        if (node == null) {
            return ret;
        }
        dfs(node, target, curList);
        return ret;
    }

    public void dfs(TreeNode node, int target, List<Integer> path) {
        path.add(node.val);

        if (node.right == null && node.left == null) {
            if (target == node.val) {
                ret.add(new LinkedList<>(path));
            }
            return;
        }

        if (node.left != null) {
            dfs(node.left, target - node.val, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            dfs(node.right, target - node.val, path);
            path.remove(path.size() - 1);
        }
    }
}
