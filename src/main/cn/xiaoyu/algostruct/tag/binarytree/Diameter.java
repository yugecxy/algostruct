package xiaoyu.algostruct.tag.binarytree;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">...</a>
 */
public class Diameter {
    private int ret = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ret;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ret = Math.max(ret, left + right);
        return Math.max(left, right) + 1;
    }
}
