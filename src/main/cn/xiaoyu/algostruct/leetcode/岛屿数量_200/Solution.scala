package cn.xiaoyu.algostruct.leetcode.岛屿数量_200

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
  */
object Solution {

  def numIslands(grid: Array[Array[Char]]): Int = {
    val map = mutable.HashMap[(Int, Int), String]()

    def recursion(i: Int, j: Int): Unit = {
      if (i >= grid.length || j >= grid(0).length || i < 0 || j < 0) return
      if (grid(i)(j) == '1' && !map.contains((i, j))) {
        map.put((i, j), null)
        recursion(i + 1, j)
        recursion(i, j + 1)
        recursion(i - 1, j)
        recursion(i, j - 1)
      }
    }

    var res = 0
    for (i <- grid.indices)
      for (j <- grid(0).indices) {
        if (!map.contains((i, j)) && grid(i)(j) == '1') {
          res += 1
          recursion(i, j)
        }
      }
    res
  }

  def main(args: Array[String]): Unit = {
    println(numIslands(
      Array(Array('1', '1', '1'),
        Array('0', '1', '0'),
        Array('1', '1', '1')
      ))
    )
  }
}
