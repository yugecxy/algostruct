package cn.xiaoyu.algostruct.structure.linkedlist;

import cn.xiaoyu.algostruct.util.Node;


/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/25
 * Desc: 链表操作
 */

public class LinkedList {
    /**
     * @param head
     * @desc 反转链表：遍历节点，cur.next=pre
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node now = cur;
            cur.next = pre;
            pre = cur;      //pre保留反向链表
            cur = now.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(2);
        Node node1 = new Node();
        node1.setValue(5);
        Node node2 = new Node();
        node2.setValue(1);
        head.setNext(node1);
        node1.setNext(node2);
        Node res = reverse(head);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
