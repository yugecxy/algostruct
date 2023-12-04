package xiaoyu.algostruct.tag.binarytree;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/">...</a>
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l != null && r != null) {
            return dfs(l.left, r.right) && dfs(l.right, r.right) & l.val == r.val;
        }
        return false;
    }
}
