package xiaoyu.algostruct.leetcode.LRU缓存机制_146

import scala.collection.mutable

class Node(x: Int) {
  var next: Node = null
  var value = x
}

class LRUCache(_capacity: Int) {

  val map = mutable.HashMap[Int, Int]()

  var head: Node = null

  var last: Node = null

  def updateUsedKey(key: Int): Unit = {
    var cur: Node = head
    var pre: Node = null
    while (cur.value != key) {
      pre = cur
      cur = cur.next
    }
    if (cur.next != null) { //如果在链表的末尾就不进行更新操作了
      if (pre == null) head = cur.next else pre.next = cur.next
      cur.next = null
      last.next = cur
      last = cur
    }
  }

  def get(key: Int): Int = {
    val value = map.getOrElse(key, -1)
    if (value != -1 && map.size > 1) updateUsedKey(key)
    value
  }

  def put(key: Int, value: Int) {
    if (!map.contains(key)) {
      if (map.size == _capacity) {
        map.remove(head.value)
        head = head.next
      }
      map.put(key, value)
      val tmp = new Node(key)
      if (head == null) {
        head = tmp
        last = head
      } else {
        last.next = tmp
        last = tmp
      }
    }
    else {
      map.update(key, value)
      if (map.size > 1) updateUsedKey(key)
    }
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val a = new LRUCache(2)
    a.put(2, 6)
    a.get(1)
    a.put(1, 5)
    a.put(1, 2)
    a.get(1)
    a.get(2)
  }
}
