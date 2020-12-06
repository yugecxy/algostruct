package xiaoyu.algostruct.leetcode.合并两个有序链表_21

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var head: ListNode = null
    var tail: ListNode = null
    var c1 = l1
    var c2 = l2
    while (c1 != null || c2 != null) {
      var cur: ListNode = null
      if (c2 == null || (c1 != null && c1.x < c2.x)) {
        cur = c1
        c1 = c1.next
      }
      else {
        cur = c2
        c2 = c2.next
      }
      if (head == null) {
        head = cur
        tail = head
      } else {
        tail.next = cur
        tail = cur
      }
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val m1 = new ListNode(1)
    val m2 = new ListNode(2)
    val m3 = new ListNode(4)
    m1.next = m2
    m2.next = m3

    val n1 = new ListNode(1)
    val n2 = new ListNode(3)
    val n3 = new ListNode(4)
    n1.next = n2
    n2.next = n3

    val ret = mergeTwoLists(m1, n1)
    ret
  }
}
