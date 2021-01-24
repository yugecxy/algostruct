package cn.xiaoyu.algostruct.offer.从上到下打印二叉树

import scala.collection.mutable

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {

  def levelOrder(root: TreeNode): List[List[Int]] = {
    val queue: mutable.Queue[TreeNode] = new mutable.Queue[TreeNode]()
    val res = new mutable.ListBuffer[List[Int]]()
    if (root == null) return res.toList
    queue.enqueue(root)
    while (queue.nonEmpty) {
      val curList = new mutable.ListBuffer[Int]()
      queue.indices.foreach(x => {
        val node = queue.dequeue()
        curList.append(node.value)
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
      })
      res.append(curList.toList)
    }
    res.toList
  }

  /**
    * @return 常规
    */
  def levelOrder2(root: TreeNode): List[Int] = {
    val queue: mutable.Queue[TreeNode] = new mutable.Queue[TreeNode]()
    val res = new mutable.ListBuffer[Int]()
    if (root == null) return res.toList
    queue.enqueue(root)
    while (queue.nonEmpty) {
      val node = queue.dequeue()
      res.append(node.value)
      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)
    }
    res.toList
  }


  def main(args: Array[String]): Unit = {
    val a = new TreeNode(3)
    val b = new TreeNode(9)
    val c = new TreeNode(20)
    val d = new TreeNode(15)
    val e = new TreeNode(7)
    a.left = b
    a.right = c
    b.left = d
    b.right = e
    val res = levelOrder2(a)
    res.foreach(println(_))
  }
}
