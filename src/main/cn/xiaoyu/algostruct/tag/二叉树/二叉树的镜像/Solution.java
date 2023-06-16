package xiaoyu.algostruct.tag.二叉树.二叉树的镜像;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/">...</a>
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;
        return root;
    }
}
