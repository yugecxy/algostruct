package xiaoyu.algostruct.tag.binarytree;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * 判断二叉树是否平衡二叉树
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = Math.abs(dfs(root.left) - dfs(root.right));
        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }

}
