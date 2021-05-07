package cn.xiaoyu.algostruct.accumulate.气球游戏

import scala.collection.mutable

object Solution {

  def shoot(arr: Array[Int], n: Int, m: Int): Int = {
    var minCnt = Int.MaxValue
    var flag = false
    var startIndex = 0
    var endIndex = 0
    val map = mutable.HashMap[Int, Int]()

    while (endIndex < n) {
      val curVal = arr(endIndex)
      map.put(curVal, map.getOrElse(curVal, 0) + 1)
      if (map.size == m) {
        flag = true
        while (map(curVal) > 1 || curVal == 0) {
          startIndex += 1
          map.put(curVal, map(curVal) - 1)
        }
        minCnt = math.min(minCnt, endIndex - startIndex)
      }
      endIndex += 1
    }

    if (flag) minCnt else -1
  }

  def main(args: Array[String]): Unit = {
    println(shoot(Array(2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3), 12, 5))
  }
}
