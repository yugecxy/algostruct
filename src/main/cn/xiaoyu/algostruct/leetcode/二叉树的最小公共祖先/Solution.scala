package cn.xiaoyu.algostruct.leetcode.二叉树的最小公共祖先

class TreeNode(_value: Int) {
  val value = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

/**
  * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
  */
object Solution {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    if (left == null && right == null) null
    else if (left == null) right
    else if (right == null) left
    else root
  }
}
