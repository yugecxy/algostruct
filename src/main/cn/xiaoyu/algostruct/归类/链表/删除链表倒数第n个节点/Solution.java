package xiaoyu.algostruct.归类.链表.删除链表倒数第n个节点;


import xiaoyu.algostruct.helper.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int diff = 0;
        while (fast != null) {
            if (diff >= n) {
                prev = slow;
                slow = slow.next;
            }
            fast = fast.next;
            diff += 1;
        }

        //删除
        if (prev == null) {
            return head.next;
        }
        prev.next = slow == null ? null : slow.next;
        return head;
    }
}
