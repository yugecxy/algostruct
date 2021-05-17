package cn.xiaoyu.algostruct.leetcode.___圆圈中最后剩下的数字

import scala.collection.mutable

object Solution {
  def lastRemaining(n: Int, m: Int): Int = {
    def dfs(n: Int, m: Int): Int = {
      if (n == 1) return 0
      val x = dfs(n - 1, m)
      (m + x) % n
    }

    dfs(n, m)
  }

  def main(args: Array[String]): Unit = {
    println(lastRemaining(5, 3))
  }
}
