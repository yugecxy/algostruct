package xiaoyu.algostruct.归类.链表.反转链表;

class Node {
    public Node next;
    public int val;

    public Node(int val) {
        this.val = val;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}

public class Solution {

    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(1);
        a.next = b;
        b.next = c;

        Node ret = new Solution().reverse(a);
        System.out.println(111);
    }

}
