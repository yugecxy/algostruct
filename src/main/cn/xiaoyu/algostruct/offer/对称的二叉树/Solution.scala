package cn.xiaoyu.algostruct.offer.对称的二叉树

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

/**
  * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
  */
object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    def dfs(left: TreeNode, right: TreeNode): Boolean = {
      if (left == null && right == null) return true
      if (left == null || right == null) return false
      left.value == right.value && dfs(left.left, right.right) && dfs(left.right, right.left)
    }

    if (root == null) return true
    dfs(root.left, root.right)
  }
}
