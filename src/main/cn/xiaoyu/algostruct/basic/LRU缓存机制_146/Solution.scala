package xiaoyu.algostruct.basic.LRU缓存机制_146

import scala.collection.mutable

class CachedNode(key: Int) {
  val value: Int = key
  var next: CachedNode = null
}

class LRUCache(_capacity: Int) {

  val data: mutable.HashMap[Int, Int] = mutable.HashMap[Int, Int]()

  //保存
  var head: CachedNode = null
  var tail: CachedNode = null

  def initCache(key: Int) = {
    val cur = new CachedNode(key)
    head = cur
    tail = cur
  }

  def insertOrUpdateCache = (key: Int, isInsert: Boolean) => {
    if (isInsert) {
      val cur = new CachedNode(key)
      tail.next = cur
      tail = cur
      if (data.size > _capacity) {
        data.remove(head.value)
        head = head.next
      }
    } else {
      //查找
      var pre: CachedNode = null
      var cur: CachedNode = head
      while (cur.value != key) {
        pre = cur
        cur = cur.next
      }
      if (cur.next != null) { // 如果节点已经在末尾则不更新
        if (pre == null) head = head.next else pre.next = cur.next
        cur.next = null
        tail.next = cur
        tail = cur
      }
    }
  }

  def get(key: Int): Int = {
    val value = data.getOrElse(key, -1)
    if (value != -1) insertOrUpdateCache(key, false)
    value
  }

  def put(key: Int, value: Int) {
    if (data.contains(key)) {
      data.update(key, value)
      insertOrUpdateCache(key, false)
    }
    else {
      if (data.isEmpty) {
        initCache(key)
        data.put(key, value)
      } else {
        data.put(key, value)
        insertOrUpdateCache(key, true)
      }
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(2)
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1); // 返回  1
    cache.put(3, 3); // 该操作会使得关键字 2 作废
    cache.get(2); // 返回 -1 (未找到)
    cache.put(4, 4); // 该操作会使得关键字 1 作废
    cache.get(1); // 返回 -1 (未找到)
    cache.get(3); // 返回  3
    cache.get(4); // 返回  4

  }
}
