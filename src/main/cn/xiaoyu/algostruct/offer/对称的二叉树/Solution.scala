package xiaoyu.algostruct.offer.对称的二叉树

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    def dfs(root1: TreeNode, root2: TreeNode): Boolean = {
      if (root1 == null && root2 == null) true
      else if (root1 != null && root2 != null) {
        if (root1.value != root2.value) return false
        dfs(root1.left, root2.right) && dfs(root1.right, root2.left)
      }
      else false
    }

    if (root == null) return true
    dfs(root.left, root.right)
  }
}
