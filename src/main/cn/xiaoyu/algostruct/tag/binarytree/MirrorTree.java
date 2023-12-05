package xiaoyu.algostruct.tag.binarytree;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/">...</a>
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = left;
        return root;
    }
}
