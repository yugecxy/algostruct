package xiaoyu.algostruct.tag.binarytree.二叉树中的最大路径和;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">...</a>
 */
public class Solution {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxValue = Math.max(maxValue, left + right + root.val);
        int maxVal = Math.max(left, right);

        return root.val + maxVal;
    }

}
