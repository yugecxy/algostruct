package cn.xiaoyu.algostruct.offer.___二叉树中和为某一个值的路径

import scala.collection.mutable.ListBuffer

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {

  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    val ret = ListBuffer[List[Int]]()
    val path = ListBuffer[Int]()

    def doFind(root: TreeNode, accuSum: Int, sum: Int): Unit = {
      if (root == null) return

      val curSum = accuSum + root.value
      path.append(root.value)

      if (root.left == null && root.right == null && curSum == sum) ret.append(path.clone().toList)

      doFind(root.left, curSum, sum)
      doFind(root.right, curSum, sum)
      path.remove(path.length - 1) //回溯是关键
    }

    doFind(root, 0, sum)
    ret.toList
  }

  def main(args: Array[String]): Unit = {

    val node1 = new TreeNode(1)
    val node2 = new TreeNode(2)
    val node3 = new TreeNode(3)
    val node4 = new TreeNode(4)
    val node5 = new TreeNode(5)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5

    pathSum(node1, 8).foreach(println(_))
  }
}
