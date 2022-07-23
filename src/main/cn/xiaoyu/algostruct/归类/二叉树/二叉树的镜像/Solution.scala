package cn.xiaoyu.algostruct.offer.二叉树的镜像


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

/**
  * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
  */
object Solution {
  def mirrorTree(root: TreeNode): TreeNode = {
    if (root == null) return null
    val tmp = mirrorTree(root.left)
    root.left = mirrorTree(root.right)
    root.right = tmp
    root
  }

  def main(args: Array[String]): Unit = {
    val a1 = new TreeNode(1)
    val a2 = new TreeNode(2)
    val a3 = new TreeNode(3)
    a1.left = a2
    a1.right = a3

    val a = mirrorTree(a1)
    println(1111)
  }
}
