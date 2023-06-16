package xiaoyu.algostruct.tag.二叉树.二叉树中和为某一个值的路径;

import java.util.LinkedList;
import java.util.List;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/">...</a>
 * 二叉树中和为某一值的路径: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径
 */
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
