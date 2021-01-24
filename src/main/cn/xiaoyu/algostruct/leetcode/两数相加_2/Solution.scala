package cn.xiaoyu.algostruct.leetcode.两数相加_2

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/add-two-numbers/
  */
object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null && l2 == null) return null
    var h1: ListNode = l1
    var h2: ListNode = l2
    var ret: ListNode = null
    var tail: ListNode = null
    var bit = 0
    while (h1 != null || h2 != null) {
      var sum = if (h1 == null) h2.x else if (h2 == null) h1.x else h1.x + h2.x
      sum += bit

      val value = if (sum < 10) {
        bit = 0
        sum
      } else {
        bit = sum / 10
        sum % 10
      }

      //输出结果
      val cur = new ListNode(value, null)
      if (ret == null) {
        ret = cur
        tail = ret
      } else {
        tail.next = cur
        tail = tail.next
      }

      if (h1 != null) h1 = h1.next
      if (h2 != null) h2 = h2.next
    }

    if (bit != 0) tail.next = new ListNode(bit, null)
    ret
  }

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(9, new ListNode(9, new ListNode(9, null)))
    var cur = l1
    while (cur != null) {
      println(cur.x)
      cur = cur.next
    }
    //    val l2 = new ListNode(9)
    //    val a = addTwoNumbers(l1, l2)
    //    println(11)

  }
}
