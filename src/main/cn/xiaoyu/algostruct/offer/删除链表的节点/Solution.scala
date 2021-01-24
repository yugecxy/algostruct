package cn.xiaoyu.algostruct.offer.删除链表的节点

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
  */
object Solution {
  def deleteNode(head: ListNode, `val`: Int): ListNode = {
    if (head == null) return null
    var ret = head
    var cur: ListNode = ret
    var pre: ListNode = null
    while (cur != null) { //假设每次要删除的数据都在链表里
      if (cur.x == `val`) {
        if (pre == null) ret = ret.next else pre.next = cur.next
      }
      pre = cur
      cur = cur.next
    }
    ret
  }
}
