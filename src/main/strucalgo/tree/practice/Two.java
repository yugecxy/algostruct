package strucalgo.tree.practice;

import strucalgo.tree.basic.BasicTree;
import strucalgo.tree.basic.InintTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc:
 */
public class Two {
    public void reverseEchoByLayer(BasicTree root) {
        Stack<Integer> stack = new Stack<>();
        Queue<BasicTree> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            BasicTree tmp = queue.poll();
            if (tmp == null) {
                break;
            }
            stack.push(tmp.getData());
            if (tmp.getRight() != null) {
                queue.offer(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                queue.offer(tmp.getLeft());
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        new Two().reverseEchoByLayer(InintTree.tree1());
    }
}
