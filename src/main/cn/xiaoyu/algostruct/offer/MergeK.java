package xiaoyu.algostruct.offer;

import java.util.*;
import xiaoyu.algostruct.helper.ListNode;

public class MergeK {
    public ListNode merge(List<ListNode> nodes) {
        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : nodes) {
            priorityQueue.offer(node);
        }
        ListNode head = null;
        ListNode tail = null;
        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            if (head == null) {
                head = cur;
                tail = head;
            } else {
                tail.next = cur;
                tail = cur;
            }
            if (cur.next != null) {
                priorityQueue.offer(cur.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);

        ListNode ret = new MergeK().merge(Arrays.asList(l1, l2));
        System.out.println(111);
    }
}
