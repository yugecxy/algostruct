package cn.xiaoyu.algostruct.tag.矩阵.顺时针打印矩阵

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
  */
object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.isEmpty) return Array[Int]()

    val length = matrix.head.length
    val width = matrix.length
    val res = mutable.ArrayBuffer[Int]()
    val records = mutable.HashSet[(Int, Int)]()

    /**
      * @param dire 0:右 1:下 2:左 3:上
      */
    def recursion(i: Int, j: Int, dire: Int): Unit = {
      if (i < 0 || i > width - 1 || j < 0 || j > length - 1 || records.contains((i, j))) return

      res.append(matrix(i)(j))
      records.add((i, j))

      dire match {
        case 0 => {
          if (j < length - 1 && !records.contains((i, j + 1))) recursion(i, j + 1, 0)
          else recursion(i + 1, j, 1)
        }
        case 1 => {
          if (i < width - 1 && !records.contains((i + 1, j))) recursion(i + 1, j, 1)
          else recursion(i, j - 1, 2)
        }
        case 2 => {
          if (j > 0 && !records.contains((i, j - 1))) recursion(i, j - 1, 2)
          else recursion(i - 1, j, 3)
        }
        case 3 => {
          if (i > 0 && !records.contains((i - 1, j))) recursion(i - 1, j, 3)
          else recursion(i, j + 1, 0)
        }
      }
    }

    recursion(0, 0, 0)
    res.toArray
  }

  def main(args: Array[String]): Unit = {
    println(spiralOrder(Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )).toSeq)
  }
}
