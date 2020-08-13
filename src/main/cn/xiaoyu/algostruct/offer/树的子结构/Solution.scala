package xiaoyu.algostruct.offer.树的子结构


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = {
    if (B == null || A == null) return false

    def findByDeep(x: TreeNode, y: TreeNode): Boolean = {
      if (y == null) true
      else if (x == null) false
      else if (x.value != y.value) false
      else findByDeep(x.left, y.left) && findByDeep(x.right, y.right)
    }

    findByDeep(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
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
