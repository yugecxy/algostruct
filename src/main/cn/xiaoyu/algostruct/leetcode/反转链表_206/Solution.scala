package xiaoyu.algostruct.leetcode.反转链表_206

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def reverseList(head: ListNode): ListNode = {
    var cur = head
    var pre:ListNode = null
    while (cur != null) {
      val nextTmp = cur.next
      cur.next = pre
      pre = cur
      cur = nextTmp
    }
    pre
  }

  def main(args: Array[String]): Unit = {
    val a = new ListNode(2)
    val b = new ListNode(3)
    val c = new ListNode(4)
    a.next = b
    b.next = c
    reverseList(a)
  }
}
