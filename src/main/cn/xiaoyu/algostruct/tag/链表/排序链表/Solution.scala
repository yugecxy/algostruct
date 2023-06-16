package xiaoyu.algostruct.tag.链表.排序链表

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/sort-list/
  */
object Solution {

  //快慢指针找到中间
  def findMiddle(head: ListNode): ListNode = {
    var fast: ListNode = head
    var slow: ListNode = head
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next
      slow = slow.next
    }
    slow
  }

  def mergeSort(head1: ListNode, head2: ListNode): ListNode = {
    var h1 = head1
    var h2 = head2
    var head: ListNode = null
    var tail: ListNode = null
    while (h1 != null || h2 != null) {
      var cur: ListNode = null
      if (h2 == null || (h1 != null && h1.x < h2.x)) {
        cur = h1
        h1 = h1.next
      }
      else {
        cur = h2
        h2 = h2.next
      }
      if (head == null) {
        head = cur
        tail = head
      }
      else {
        tail.next = cur
        tail = cur
      }
    }
    head
  }

  def sortList(head: ListNode): ListNode = {

    def recursive(head: ListNode): ListNode = {
      val middle = findMiddle(head)

      //只有一个节点的case
      if (middle.next == null) {
        return middle
      }

      val rightHead = middle.next
      middle.next = null

      mergeSort(recursive(head), recursive(rightHead))
    }

    if (head == null) return null
    recursive(head)
  }

  def main(args: Array[String]): Unit = {
    val a = new ListNode(2)
    val b = new ListNode(4)
    val c = new ListNode(9)
    val d = new ListNode(1)
    val e = new ListNode(7)
    val f = new ListNode(10)
    //    val e = new ListNode(5)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    e.next = f

    //    d.next = e
    val x = sortList(a)
    println(x.x)


  }
}
