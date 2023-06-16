package xiaoyu.algostruct.tag.二叉树.二叉树的右侧视图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import xiaoyu.algostruct.helper.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        List<Integer> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            int countOnLevel = queue.size();
            TreeNode lastNode = new TreeNode(-1);
            while (countOnLevel-- > 0) {
                lastNode = queue.poll();
                if (lastNode.left != null) {
                    queue.offer(lastNode.left);
                }
                if (lastNode.right != null) {
                    queue.offer(lastNode.right);
                }
            }
            ret.add(lastNode.val);
        }
        return ret;
    }
}
