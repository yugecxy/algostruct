package xiaoyu.algostruct.leetcode.买入股票的最佳时期_121

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length <= 1) return 0
    var max = Int.MinValue
    var min = prices(0)
    for (p <- prices.drop(1)) {
      max = math.max(p - min, max)
      min = math.min(p, min)
    }
    math.max(max, 0)
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
  }
}
