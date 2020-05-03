package xiaoyu.algostruct.leetcode.会议室II_253

import scala.collection.mutable

object Solution {

  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    val endTimes = mutable.ArrayBuffer[Int]()
    intervals.sortBy(_ (0)).foreach(x => {
      if (endTimes.isEmpty) endTimes.append(x(1))
      else {
        val min = endTimes.min
        if (x(0) < min) endTimes.append(x(1))
        else {
          endTimes.remove(endTimes.indexWhere(x => x == min))
          endTimes.append(x(1))
        }
      }
    })
    endTimes.length
  }

  def main(args: Array[String]): Unit = {
    println(minMeetingRooms(Array(
      Array(9, 10),
      Array(4, 9),
      Array(4, 17)
    )))
  }
}
