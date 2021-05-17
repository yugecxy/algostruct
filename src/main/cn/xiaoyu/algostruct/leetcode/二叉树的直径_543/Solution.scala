package cn.xiaoyu.algostruct.leetcode.二叉树的直径_543

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var ans = 1

    def depth(node: TreeNode): Int = {
      if (node == null) return 0
      val L = depth(node.left)
      val R = depth(node.right)
      ans = Math.max(ans, L + R + 1)
      Math.max(L, R) + 1
    }

    depth(root)
    ans - 1
  }

  def main(args: Array[String]): Unit = {
    println(diameterOfBinaryTree(null))
  }
}
