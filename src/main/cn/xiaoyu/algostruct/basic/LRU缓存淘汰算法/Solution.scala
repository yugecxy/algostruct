package cn.xiaoyu.algostruct.basic.LRU缓存淘汰算法

import scala.collection.mutable

class LRUNode(_key: Int = -1) {
  var key: Int = _key
  var next: LRUNode = null
  var prev: LRUNode = null
}

class LRUCache(capacity: Int) {
  var headNode: LRUNode = null
  var tailNode: LRUNode = null
  var data = mutable.HashMap[Int, (Int, LRUNode)]()

  def init() = {
    headNode = new LRUNode()
    tailNode = new LRUNode()
    headNode.next = tailNode
    tailNode.prev = headNode
  }

  def get(key: Int): Int = {
    if (!data.contains(key)) return -1
    moveNodeToTail(data(key)._2)
    data(key)._1
  }

  def put(key: Int, value: Int): Unit = {
    if (!data.contains(key)) {
      if (data.size == capacity) {
        val toDelete = headNode.next
        deleteNode(toDelete)
        data.remove(toDelete.key)
      }

      val newNode = new LRUNode(key)
      moveNodeToTail(newNode)
      data.put(key, (value, newNode))
    }
    else {
      val item = data(key)
      deleteNode(item._2)
      moveNodeToTail(item._2)
      data.put(key, (value, item._2))
    }

  }

  def deleteNode(node: LRUNode) = {
    node.prev.next = node.next
    node.next.prev = node.prev
  }

  def moveNodeToTail(node: LRUNode) = {
    tailNode.prev.next = node
    node.prev = tailNode.prev
    tailNode.prev = node
    node.next = tailNode
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val lru = new LRUCache(2)
    lru.init()
    lru.put(2, 3)
    lru.put(3, 3)
    lru.put(2, 5)
    lru.put(4, 3)
    println(lru.get(2))
  }
}
