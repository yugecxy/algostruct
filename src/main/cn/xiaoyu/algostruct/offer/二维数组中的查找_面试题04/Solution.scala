package xiaoyu.algostruct.offer.二维数组中的查找_面试题04

object Solution {
  def findNumberIn2DArray(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty) return false
    var i, j = 0
    while (i < matrix.length && j < matrix.head.length) {
      if(matrix(i)(matrix.head.length-1) > target) {
        1
      }
    }
    false
  }
}
