package xiaoyu.algostruct.leetcode.环形链表_141

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {

  def hasCycle(head: ListNode): Boolean = {
    var fast = head
    var slow = head
    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
      if (fast == slow) return true
    }
    return false
  }

  def main(args: Array[String]): Unit = {
    val n1 = new ListNode(1)
    val n2 = new ListNode(2)
    val n3 = new ListNode(3)
    n1.next = n2
    n2.next = n3
    n3.next = null
    println(hasCycle(n1))
  }
}
