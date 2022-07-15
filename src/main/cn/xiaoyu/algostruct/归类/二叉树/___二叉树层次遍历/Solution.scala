package cn.xiaoyu.algostruct.归类.二叉树.___二叉树层次遍历

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {

  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return List[List[Int]]()
    val queue = mutable.Queue[TreeNode]()
    var ret = List[List[Int]]()
    queue.enqueue(root)
    while (queue.nonEmpty) {
      var cur = List[Int]()
      var i = 0
      val queueLen = queue.length
      while (i < queueLen) {
        val node = queue.dequeue()
        cur :+= node.value

        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
        i += 1
      }
      ret :+= cur
    }
    ret
  }

  def main(args: Array[String]): Unit = {
    val head = new TreeNode(3)
    val node1 = new TreeNode(9)
    val node2 = new TreeNode(20)
    val node3 = new TreeNode(15)
    val node4 = new TreeNode(7)
    head.left = node1
    head.right = node2
    node2.left = node3
    node2.right = node4
    println(levelOrder(head))
  }
}
