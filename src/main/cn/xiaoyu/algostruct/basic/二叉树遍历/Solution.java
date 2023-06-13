package xiaoyu.algostruct.basic.二叉树遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
    /**
     * @return 前序
     */
    public List<Integer> preOrder(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> ret = new LinkedList<>();
        ret.add(root.getVal());
        ret.addAll(preOrder(root.getLeft()));
        ret.addAll(preOrder(root.getRight()));
        return ret;
    }

    /**
     * @return 层次
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueLen = queue.size() - 1;
            List<Integer> curL = new LinkedList<>();
            while (queueLen-- >= 0) {
                TreeNode tmp = queue.poll();
                curL.add(tmp.getVal());

                if (tmp.getLeft() != null) queue.offer(tmp.getLeft());
                if (tmp.getRight() != null) queue.offer(tmp.getRight());
            }
            ret.add(curL);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        c.setRight(e);
        List<List<Integer>> ret = solution.levelOrder(a);
        System.out.println(ret);
    }
}

class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
