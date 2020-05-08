package xiaoyu.algostruct.leetcode.二叉树中的最大路径和_124

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {


  def maxPathSum(root: TreeNode): Int = {
    var max = Integer.MIN_VALUE

    def compute(root: TreeNode): Int = {
      if (root == null) return 0

      val left = math.max(compute(root.left), 0)
      val right = math.max(compute(root.right), 0)
      val sum = root.value + left + right
      max = math.max(sum, max)
      root.value + math.max(left, right)
    }

    compute(root)
    max
  }

  def main(args: Array[String]): Unit = {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(-2)
    val n3 = new TreeNode(-3)
    val n4 = new TreeNode(1)
    val n5 = new TreeNode(3)
    val n6 = new TreeNode(-2)
    val n7 = new TreeNode(-1)

    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = null
    n4.left = n7

    println(maxPathSum(n1))
  }
}
