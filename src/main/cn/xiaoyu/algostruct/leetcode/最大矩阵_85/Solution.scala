package xiaoyu.algostruct.leetcode.最大矩阵_85

object Solution {

  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0
    val length = matrix(0).length
    val width = matrix.length
    var res = 0
    for (i <- 0 until width) {
      for (j <- 0 until length) {
        val bp = matrix(i)(j)
        if (bp == '1') {
          var a = i
          var x = Int.MaxValue

          while (a < width && matrix(a)(j) == '1') {
            var tmpX = 0
            var b = j
            while (b < length && matrix(a)(b) == '1') {
              tmpX += 1
              b += 1
            }
            x = math.min(tmpX, x)
            a += 1
          }

          if (x == Int.MaxValue) x = 1

          res = math.max((a - i) * x, res)
        }
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    println(maximalRectangle(Array(
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0')
    )))
  }
}
