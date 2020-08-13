package xiaoyu.algostruct.offer.树的子结构


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = {
    if (B == null) return false

    def findByDeep(x: TreeNode, y: TreeNode): Boolean = {
      if (y == null) return true
      if (x == null && y == null) true
      else if (x != null && y != null) {
        if (x.value == y.value) {
          findByDeep(x.left, y.left) && findByDeep(x.right, y.right)
        }
        else false
      }
      else false
    }

    def lookupAByDeep(x: TreeNode): Boolean = {
      if (x == null) return false
      val bol = findByDeep(x, B)
      if (bol) true else {
        lookupAByDeep(x.left) || lookupAByDeep(x.right)
      }
    }

    lookupAByDeep(A)
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
