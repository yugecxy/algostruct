package xiaoyu.algostruct.归类.二叉树.二叉树深度;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
