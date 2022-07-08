package xiaoyu.algostruct.归类.环形链表.检测链表是否有环;

import xiaoyu.algostruct.helper.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/">...</a>
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
