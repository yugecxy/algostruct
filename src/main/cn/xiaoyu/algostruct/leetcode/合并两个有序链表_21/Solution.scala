package xiaoyu.algostruct.leetcode.合并两个有序链表_21

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null && l2 == null) return null
    var h1 = l1
    var h2 = l2
    var retTail: ListNode = null
    var retHead: ListNode = null
    while (h1 != null || h2 != null) {
      var newNode: ListNode = null
      if (h2 == null || (h1 != null && h1.x < h2.x)) {
        newNode = new ListNode(h1.x)
        h1 = h1.next
      }
      else {
        newNode = new ListNode(h2.x)
        h2 = h2.next
      }
      if (retHead == null) {
        retHead = newNode
        retTail = retHead
      }
      else {
        retTail.next = newNode
        retTail = newNode
      }
    }
    retHead
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
