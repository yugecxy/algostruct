package cn.xiaoyu.algostruct.offer.___剪绳子

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
  */
object Solution {

  def cuttingRope(n: Int): Int = {
    val map = mutable.HashMap[Int, Int]()

    def dfs(n: Int): Int = {
      if (n <= 2) return 1
      val max = if (map.contains(n)) map(n) else {
        (1 until n).map(x => math.max(x * dfs(n - x), x * (n - x))).max
      }
      map.put(n, max)
      max
    }

    dfs(n)
  }

  def main(args: Array[String]): Unit = {
    println(4*3*2)
  }
}
