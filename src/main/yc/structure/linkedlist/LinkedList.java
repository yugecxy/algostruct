package structure.linkedlist;

import util.Common.*;

import java.util.*;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/7/25
 * Desc: 链表操作
 */
class Node {
    int value;
    Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedList {
    /**
     * @param head
     */
    public static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        Node first = null;
        while (cur != null) {
            if (cur.next == null) {
                first = cur;
            }
            Node nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return first;
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
        Node res=reverse(head);
        while(res!=null)
        {
            System.out.println(res.value);
            res=res.next;
        }
    }
}
