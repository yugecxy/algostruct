package xiaoyu.algostruct.tag.binarytree.前序遍历构造二叉搜索树;

import java.util.Stack;

import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/">...</a>
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = new TreeNode(preorder[i]);
            TreeNode top = stack.peek();
            if (top.val > preorder[i]) {
                top.left = cur;
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek().val < preorder[i]) {
                    top = stack.peek();
                    stack.pop();
                }
                top.right = cur;
                stack.push(cur);
            }
        }
        return root;
    }

    /**
     * 方案二：先排序获取中序遍历，然后根据中序和前序就可以构建
     */
    public TreeNode bstFromPreorder2(int[] preorder) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new Solution().bstFromPreorder(new int[]{8,5,1,7,10,12});
        System.out.println(111);
    }
}
