package xiaoyu.algostruct.归类.二叉树.树的子结构;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/">...</a>
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return find(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean find(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && find(A.left, B.left) && find(A.right, B.right);
    }
}
