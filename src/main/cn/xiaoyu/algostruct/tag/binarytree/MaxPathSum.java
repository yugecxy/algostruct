package xiaoyu.algostruct.tag.binarytree;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">...</a>
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, l + r + node.val);
        return node.val + Math.max(l, r);
    }
}
