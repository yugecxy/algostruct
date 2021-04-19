package cn.xiaoyu.algostruct.basic.LRU缓存机制_146

import scala.collection.mutable

class Node(_key: Int = -1) {
  var key = _key
  var next: Node = null
  var prev: Node = null
}

class Solution2 {
  def this(_capacity: Int) = {
    this()
    this.headNode = new Node()
    this.tailNode = new Node()
    this.headNode.next = tailNode
    this.tailNode.prev = headNode
    this.capacity = _capacity
    this.data = new mutable.HashMap[Int, (Int, Node)]()
  }

  var capacity: Int = _
  var headNode: Node = _
  var tailNode: Node = _

  var data: mutable.HashMap[Int, (Int, Node)] = null

  def get(key: Int): Int = {
    if (!data.contains(key)) return -1
    moveNodeToTail(data(key)._2)
    data(key)._1
  }

  def put(key: Int, value: Int) = {
    if (!data.contains(key)) {
      val newNode = new Node(key)
      moveNodeToTail(newNode)
      data.put(key, (value, newNode))
      if (data.size > capacity) {
        val toDelete = headNode.next
        deleteNode(toDelete)
        data.remove(toDelete.key)
      }
    }
    else {
      val item = data(key)
      deleteNode(item._2)
      moveNodeToTail(item._2)
      data.put(key, (key, item._2))
    }

  }

  def deleteNode(node: Node) = {
    node.prev.next = node.next
    node.next.prev = node.prev
  }

  def moveNodeToTail(node: Node) = {
    tailNode.prev.next = node
    node.prev = tailNode.prev
    tailNode.prev = node
    node.next = tailNode
  }
}
