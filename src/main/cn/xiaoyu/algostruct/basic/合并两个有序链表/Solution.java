package xiaoyu.algostruct.basic.合并两个有序链表;

import java.util.List;

import xiaoyu.algostruct.helper.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode nextP = ret;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                nextP.next = l1;
                l1 = l1.next;
            } else {
                nextP.next = l2;
                l2 = l2.next;
            }
            nextP = nextP.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);

        ListNode ret = new Solution().mergeTwoLists(l1, l2);
        System.out.println(111);
    }
}
