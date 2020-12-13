package cn.xiaoyu.algostruct.leetcode.根据身高重建队列_406

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
  */
object Solution {

  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val sorted = people.sortBy(x => (-x(0), x(1)))
    val res = mutable.ArrayBuffer[Array[Int]]()
    for (i <- sorted.indices) {
      val rank = sorted(i)(1)
      if (rank >= res.length) res.append(sorted(i))
      else res.insert(rank, sorted(i))
    }
    res.toArray
  }

  def main(args: Array[String]): Unit = {
    reconstructQueue(
      Array(
        Array(9, 0),
        Array(7, 0),
        Array(1, 9),
        Array(3, 0),
        Array(2, 7),
        Array(5, 3),
        Array(6, 0),
        Array(3, 4),
        Array(6, 2),
        Array(5, 2)
      )
    ).foreach(x => println(x.mkString(",")))
  }
}
