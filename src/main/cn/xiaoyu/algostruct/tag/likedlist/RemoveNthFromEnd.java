package xiaoyu.algostruct.tag.likedlist;

import xiaoyu.algostruct.helper.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int cnt = 1;
        while (fast.next != null) {
            if (cnt >= n) {
                prev = slow;
                slow = slow.next;
            }
            fast = fast.next;
            cnt += 1;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = slow.next;
        }
        return head;
    }

    public ListNode removeNthFromStart(ListNode head, int n) {
        ListNode prev = null;
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt += 1;
            if (cnt == n) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
