package xiaoyu.algostruct.offer.顺时针打印矩阵

object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.isEmpty) return Array[Int]()

    val length = matrix.head.length
    val width = matrix.length
    var res: Array[Int] = Array()

    /**
      * @param dire 0:右 1:下 2:左 3:上
      */
    def recursion(i: Int, j: Int, dire: Int): Unit = {
      val cur = matrix(i)(j)
      res :+= cur
      matrix(i)(j) = Int.MinValue

      dire match {
        case 0 => {
          if (j < length - 1 && matrix(i)(j + 1) != Int.MinValue) recursion(i, j + 1, 0)
          else if (i < width - 1 && matrix(i + 1)(j) != Int.MinValue) recursion(i + 1, j, 1)
        }
        case 1 => {
          if (i < width - 1 && matrix(i + 1)(j) != Int.MinValue) recursion(i + 1, j, 1)
          else if (j > 0 && matrix(i)(j - 1) != Int.MinValue) recursion(i, j - 1, 2)
        }
        case 2 => {
          if (j > 0 && matrix(i)(j - 1) != Int.MinValue) recursion(i, j - 1, 2)
          else if (i > 0 && matrix(i - 1)(j) != Int.MinValue) recursion(i - 1, j, 3)
        }
        case 3 => {
          if (i > 0 && matrix(i - 1)(j) != Int.MinValue) recursion(i - 1, j, 3)
          else if (j < length - 1 && matrix(i)(j + 1) != Int.MinValue) recursion(i, j + 1, 0)
        }
      }
    }

    recursion(0, 0, 0)
    res
  }

  def main(args: Array[String]): Unit = {
    val input = Array(

    )

    spiralOrder(input).foreach(println(_))

  }
}
