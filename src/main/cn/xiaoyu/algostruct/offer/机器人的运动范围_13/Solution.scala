package xiaoyu.algostruct.offer.机器人的运动范围_13

import scala.collection.mutable

object Solution {
  def movingCount(m: Int, n: Int, k: Int): Int = {
    var set = mutable.HashSet[(Int, Int)]()

    var cnt = 0

    def dfs(x: Int, y: Int): Unit = {
      if (x < 0 || y < 0 || x > m - 1 || y > n - 1) return
      if (set.contains((x, y))) return
      if (x % 10 + x / 10 + y % 10 + y / 10 > k) return

      set += ((x, y))
      cnt += 1
      dfs(x + 1, y)
      dfs(x - 1, y)
      dfs(x, y + 1)
      dfs(x, y - 1)
    }

    dfs(0, 0)
    cnt
  }

  def main(args: Array[String]): Unit = {
    println(movingCount(2, 3, 1))
  }
}
