package xiaoyu.algostruct.tag.环形链表.链表中环的入口节点;

import xiaoyu.algostruct.helper.ListNode;

/**
 * <a href="https://leetcode.cn/problems/c32eOV/">...</a>
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //寻找第一次相遇点
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        //使其第二次相遇
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
