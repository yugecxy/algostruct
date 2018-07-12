package strucalgo.tree.practice;

import strucalgo.tree.basic.BasicTree;
import strucalgo.tree.basic.InintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc: 查找二叉树中最大的元素
 */
public class One {
    public int max(BasicTree root) {
        int max = Integer.MIN_VALUE;
        Queue<BasicTree> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            BasicTree tmp = queue.poll();
            if (tmp == null) {
                break;
            }
            if (tmp.getData() > max) {
                max = tmp.getData();
            }
            if (tmp.getLeft() != null) {
                queue.offer(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.offer(tmp.getRight());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new One().max(InintTree.tree1()));
    }
}
