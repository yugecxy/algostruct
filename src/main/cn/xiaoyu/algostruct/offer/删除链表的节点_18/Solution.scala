package xiaoyu.algostruct.offer.删除链表的节点_18

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def deleteNode(head: ListNode, `val`: Int): ListNode = {
    if (head == null) return null
    var cur: ListNode = head
    var pre: ListNode = null
    while (cur.next != null && cur.x != `val`) { //假设每次要删除的数据都在链表里
      pre = cur
      cur = cur.next
    }
    if (pre == null) head.next else {
      pre.next = cur.next
      head
    }
  }
}
