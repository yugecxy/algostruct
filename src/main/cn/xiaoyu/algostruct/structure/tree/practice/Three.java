package cn.xiaoyu.algostruct.structure.tree.practice;

import cn.xiaoyu.algostruct.structure.tree.basic.BasicTree;
import cn.xiaoyu.algostruct.structure.tree.basic.InintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/12
 * Desc:
 */
public class Three {
    public int height(BasicTree root) {
        int layer = 1;
        Queue<BasicTree> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);     // 每层结束后添加null表示表示该层遍历结束
        while (!queue.isEmpty()) {
            BasicTree tmp = queue.poll();
            if (tmp == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                layer += 1;
            } else {
                if (tmp.getRight() != null) {
                    queue.offer(tmp.getRight());
                }
                if (tmp.getLeft() != null) {
                    queue.offer(tmp.getLeft());
                }
            }
        }
        return layer;
    }

    public BasicTree maxHeight(BasicTree root) {
        if (root == null) {
            return null;
        }
        Queue<BasicTree> queue = new LinkedList();
        queue.offer(root);
        BasicTree tmp = new BasicTree();
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp.getLeft() != null) {
                queue.offer(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.offer(tmp.getRight());
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Three().maxHeight(InintTree.tree1()));
    }
}
