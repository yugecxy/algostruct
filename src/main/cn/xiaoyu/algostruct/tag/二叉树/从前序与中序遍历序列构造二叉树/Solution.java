package xiaoyu.algostruct.tag.二叉树.从前序与中序遍历序列构造二叉树;


import xiaoyu.algostruct.helper.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">...</a>
 */
public class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        if (in.length == 0) {
            return null;
        }
        return dfs(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode dfs(int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        if (inL > inR) {
            return null;
        }
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preL]) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(pre[preL]);
        TreeNode left = dfs(pre, in, preL + 1, preL + (rootIndex - inL), inL, rootIndex - 1);
        TreeNode right = dfs(pre, in, preL + (rootIndex - inL) + 1, preR, rootIndex + 1, inR);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Solution().buildTree(
                new int[]{8, 5, 1, 7, 10, 12},
                new int[]{1, 5, 7, 8, 10, 12}
        );
        System.out.println(111);
    }
}
