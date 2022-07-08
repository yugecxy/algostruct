package xiaoyu.algostruct.leetcode.___检测链表是否有环;

import xiaoyu.algostruct.helper.Node;

/**
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/">...</a>
 */
public class Solution {
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
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
