package xiaoyu.algostruct.leetcode.最大正方形_221

object Solution {

  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0
    val length = matrix(0).length
    val width = matrix.length
    var res = 0
    for (i <- 0 until width) {
      for (j <- 0 until length) {
        val bp = matrix(i)(j)
        if (bp == '1') {
          var a = i
          var y = Int.MaxValue

          while (a < width && matrix(a)(j) == '1' && a - i + 1 <= y) {
            var b = j
            while (b < length && matrix(a)(b) == '1') b += 1
            y = math.min(b - j, y)
            val edge = math.min(a - i + 1, y)
            res = math.max(edge * edge, res)
            a += 1
          }
        }
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    println(maximalSquare(Array(
      Array('1', '0', '0', '0'),
      Array('1', '1', '1', '1'),
      Array('1', '1', '1', '0')
    )))
  }
}
