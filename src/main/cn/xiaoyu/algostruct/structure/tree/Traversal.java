package cn.xiaoyu.algostruct.structure.tree;

import cn.xiaoyu.algostruct.structure.tree.basic.BasicTree;
import cn.xiaoyu.algostruct.structure.tree.basic.InintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc: 二叉树的遍历
 */
public class Traversal {
    /**
     * Desc: 前序遍历递归
     */
    public void forwardRecursion(BasicTree root) {
        if (root != null) {
            System.out.println(root.getData());
            new Traversal().forwardRecursion(root.getLeft());
            new Traversal().forwardRecursion(root.getRight());
        }
    }

    /**
     * Desc: 中序遍历递归
     */
    public void middleRecursion(BasicTree root) {
        if (root != null) {
            new Traversal().middleRecursion(root.getLeft());
            System.out.println(root.getData());
            new Traversal().middleRecursion(root.getRight());
        }
    }

    /**
     * Desc: 后序遍历递归
     */
    public void behindRecursion(BasicTree root) {
        if (root != null) {
            new Traversal().behindRecursion(root.getLeft());
            new Traversal().behindRecursion(root.getRight());
            System.out.println(root.getData());
        }
    }

    /**
     * Desc: 层次遍历（队列实现）
     * 访问l层时将l+1层入队
     */
    public void layer(BasicTree root) {
        if (root == null) {
            return;
        }
        Queue<BasicTree> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BasicTree tmp = queue.poll();
            System.out.println(tmp.getData());
            if (tmp.getLeft() != null) {
                queue.offer(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.offer(tmp.getRight());
            }
        }
    }

    public static void main(String[] args) {
        new Traversal().layer(InintTree.tree1());
    }
}
