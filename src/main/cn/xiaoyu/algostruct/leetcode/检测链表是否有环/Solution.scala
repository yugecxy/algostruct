package cn.xiaoyu.algostruct.leetcode.检测链表是否有环

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/linked-list-cycle/
  */
object Solution {

  def hasCycle(head: ListNode): Boolean = {
    var fast = head
    var slow = head
    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
      if (fast == slow) return true
    }
    false
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
