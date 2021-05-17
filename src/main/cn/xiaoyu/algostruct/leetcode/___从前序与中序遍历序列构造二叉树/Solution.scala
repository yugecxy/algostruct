package cn.xiaoyu.algostruct.leetcode.___从前序与中序遍历序列构造二叉树

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
  */
object Solution {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.length != inorder.length) return null
    val map = inorder.zipWithIndex.toMap
    doBuildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1)
  }

  def doBuildTree(preOrder: Array[Int], map: Map[Int, Int], preBegin: Int, preEnd: Int, inBegin: Int, inEnd: Int): TreeNode = {
    if (preBegin > preEnd || inBegin > inEnd) return null
    val rootVal = preOrder(preBegin)
    val root = new TreeNode(rootVal)
    val rootIndex = map(rootVal)
    root.left = doBuildTree(preOrder, map, preBegin + 1, preBegin + rootIndex - inBegin, inBegin, rootIndex - 1)
    root.right = doBuildTree(preOrder, map, preBegin + rootIndex - inBegin + 1, preEnd, rootIndex + 1, inEnd)
    root
  }
}
