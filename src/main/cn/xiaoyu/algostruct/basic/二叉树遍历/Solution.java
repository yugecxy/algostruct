package xiaoyu.algostruct.basic.二叉树遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            root = pop.right;
        }
        return ret;
    }

    /**
     * 中序
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            ret.add(pop.val);
            root = pop.right;
        }
        return ret;
    }

    public static void main(String[] args) {

    }


}
