package strucalgo.tree.practice;

import strucalgo.tree.basic.BasicTree;
import strucalgo.tree.basic.InintTree;

import java.util.Stack;

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
    public void forwardRecursion(BasicTree basicTree) {
        if (basicTree != null) {
            System.out.println(basicTree.getData());
            new Traversal().forwardRecursion(basicTree.getLeft());
            new Traversal().forwardRecursion(basicTree.getRight());
        }
    }

    /**
     * Desc: 中序遍历递归
     */
    public void middleRecursion(BasicTree basicTree) {
        if (basicTree != null) {
            new Traversal().middleRecursion(basicTree.getLeft());
            System.out.println(basicTree.getData());
            new Traversal().middleRecursion(basicTree.getRight());
        }
    }

    /**
     * Desc: 后序遍历递归
     */
    public void behindRecursion(BasicTree basicTree) {
        if (basicTree != null) {
            new Traversal().behindRecursion(basicTree.getLeft());
            new Traversal().behindRecursion(basicTree.getRight());
            System.out.println(basicTree.getData());
        }
    }





    public static void main(String[] args) {
        new Traversal().behindRecursion(InintTree.tree1());
    }
}
