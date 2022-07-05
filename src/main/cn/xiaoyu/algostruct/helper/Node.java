package xiaoyu.algostruct.helper;

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public void setLeft(Node next) {
        this.next = next;
    }
}
