package xiaoyu.algostruct.leetcode.检测链表是否有环

object Solution {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def hasCycle(head: ListNode): Boolean = {
    var fast: ListNode = head
    var slow: ListNode = head
    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
      if (slow == fast) return true
    }
    false
  }
}
