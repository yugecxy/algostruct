package xiaoyu.algostruct.归类.二叉树.对称的二叉树;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/">...</a>
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return dfs(left.left, right.right) && dfs(left.right, right.left) && left.val == right.val;
        } else {
            return false;
        }
    }
}