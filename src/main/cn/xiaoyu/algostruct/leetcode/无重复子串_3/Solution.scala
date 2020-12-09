package cn.xiaoyu.algostruct.leetcode.无重复子串_3

import scala.collection.mutable

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var max = 0
    var begin = 0
    val map = mutable.HashMap[Char, Int]()
    s.zipWithIndex.foreach { case (c, index) => {
      if (!map.contains(c)) map.put(c, index)
      else {
        begin = math.max(map(c) + 1, begin)
        map.put(c, index)
      }
      max = math.max(index - begin + 1, max)
    }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("tmmzuxt"))
  }
}
