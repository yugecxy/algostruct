package cn.xiaoyu.algostruct.offer.___树的子结构


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = {
    if (A == null || B == null) return false

    def find(a: TreeNode, b: TreeNode): Boolean = {
      if (b == null) true
      else if (a == null) false
      else a.value == b.value && find(a.left, b.left) && find(a.right, b.right)
    }

    find(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
  }

  def main(args: Array[String]): Unit = {
    val a1 = new TreeNode(1)
    val a2 = new TreeNode(2)
    val a3 = new TreeNode(3)
    a1.left = a2
    a1.right = a3

    val b1 = new TreeNode(1)
    val b2 = new TreeNode(2)
    b1.left = b2
    println(isSubStructure(a1, b1))
  }
}
