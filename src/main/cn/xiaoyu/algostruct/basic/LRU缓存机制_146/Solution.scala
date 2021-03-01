package cn.xiaoyu.algostruct.basic.LRU缓存机制_146

import scala.collection.mutable

class CachedNode(key: Int = -1) {
  var value: Int = key
  var next: CachedNode = _
  var pre: CachedNode = _
}

class LRUCache {

  def this(_capacity: Int) = {
    this()
    this.capacity = _capacity
    this.head = new CachedNode()
    this.tail = new CachedNode()
    head.next = tail
    tail.pre = head
  }

  val data: mutable.HashMap[Int, (Int, CachedNode)] = mutable.HashMap[Int, (Int, CachedNode)]()

  //保存
  var head: CachedNode = _
  var tail: CachedNode = _
  var capacity: Int = _

  def addNodeToTail(node: CachedNode): Unit = {
    tail.pre.next = node
    node.pre = tail.pre
    node.next = tail
    tail.pre = node
  }


  def removeNode(node: CachedNode): Unit = {
    node.pre.next = node.next
    node.next.pre = node.pre
  }

  def get(key: Int): Int = {
    if (!data.contains(key)) return -1

    val (value, node) = data(key)
    removeNode(node)
    addNodeToTail(node)
    value
  }

  def put(key: Int, value: Int) {
    if (!data.contains(key)) {
      val node = new CachedNode(key)
      addNodeToTail(node)
      if (data.size == capacity) {
        //删除头结点
        val toDeleteNode = head.next
        removeNode(toDeleteNode)
        data.remove(toDeleteNode.value)
      }
      data.put(key, (value, node))
    }
    else {
      val node = data(key)._2
      removeNode(node)
      addNodeToTail(node)
      data.put(key, (value, node))
    }

  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(2)
    cache.get(2)
    cache.put(2, 1)
    cache.put(2, 2)
    cache.get(2)
    cache.put(1, 1)
    cache.put(4, 1)
    cache.get(2)

  }
}
