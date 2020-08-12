package xiaoyu.algostruct.offer.链表中倒数第k个节点_22

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * 双指针
  */
object Solution {
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    var fastNode = head
    var slowNode = head
    var t = 1
    while (fastNode.next != null) {
      if (t >= k) slowNode = slowNode.next
      fastNode = fastNode.next
      t += 1
    }
    slowNode
  }

  def main(args: Array[String]): Unit = {

  }
}
