package cn.xiaoyu.algostruct.offer.二维数组中的查找_面试题04

/**
  * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
  */
object Solution {
  def findNumberIn2DArray(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty) return false
    var i = 0
    var j = matrix.head.length - 1
    while (i <= matrix.length - 1 && j >= 0) {
      if (matrix(i)(j) == target) return true
      else if (matrix(i)(j) > target) j = j - 1
      else i = i + 1
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val matrix = Array(
      Array(1, 4, 7, 11, 15),
      Array(2, 5, 8, 12, 19),
      Array(3, 6, 9, 16, 22),
      Array(10, 13, 14, 17, 24),
      Array(18, 21, 23, 26, 30)
    )
    println(findNumberIn2DArray(matrix, 5))
  }
}
