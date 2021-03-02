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


  //求最大利润并且同时返回买卖的点
  def maxProfit2(prices: Array[Int]): (Int, Int, Int) = {
    var min = Int.MaxValue
    var minIndex = -1
    var maxIndex = -1
    var max = Int.MinValue
    prices.indices.foreach(index => {
      val curPrice = prices(index)
      if (curPrice < min) {
        min = curPrice
        minIndex = index
      }
      if (curPrice - min > max) {
        max = curPrice - min
        maxIndex = index
      }
    })
    (max, minIndex, maxIndex)
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit2(Array(7, 1, 5, 3, 6, 4)))
  }
}
