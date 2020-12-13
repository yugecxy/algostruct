package cn.xiaoyu.algostruct.offer.股票的最大利润

/**
  * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
  */
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var min = Integer.MAX_VALUE
    var maxProfit = 0
    prices.foreach(p => {
      maxProfit = Math.max(maxProfit, p - min)
      min = Math.min(p, min)
    })
    maxProfit
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7, 1, 5, 3, 6, 4)))
  }
}
