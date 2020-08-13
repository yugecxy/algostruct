package cn.xiaoyu.algostruct.test

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var cur1 = l1
    var cur2 = l2
    var res: ListNode = null
    var resHead: ListNode = null
    while (cur1 != null || cur2 != null) {
      if (cur2 == null || (cur1 != null && cur1.x < cur2.x)) {
        val tmpNode = new ListNode(cur1.x)
        if (res == null) {
          res = tmpNode
          resHead = res
        } else {
          res.next = tmpNode
          res = tmpNode
        }
        cur1 = cur1.next
      } else {
        val tmpNode = new ListNode(cur2.x)
        if (res == null) {
          res = tmpNode
          resHead = res
        } else {
          res.next = tmpNode
          res = tmpNode
        }
        cur2 = cur2.next
      }
    }
    resHead
  }

  def main(args: Array[String]): Unit = {
    val n1 = new ListNode(1)
    val n2 = new ListNode(2)
    val n3 = new ListNode(4)
    n1.next = n2
    n2.next = n3

    val x1 = new ListNode(1)
    val x2 = new ListNode(3)
    val x3 = new ListNode(4)
    x1.next = x2
    x2.next = x3

    mergeTwoLists(n1, x1)
  }
}
