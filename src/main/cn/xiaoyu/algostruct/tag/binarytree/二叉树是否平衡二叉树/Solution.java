package xiaoyu.algostruct.tag.binarytree.二叉树是否平衡二叉树;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = getDepth(root.left) - getDepth(root.right);
        return (Math.abs(diff) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
