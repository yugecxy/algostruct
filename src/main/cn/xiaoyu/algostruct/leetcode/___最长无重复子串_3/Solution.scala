package cn.xiaoyu.algostruct.leetcode.___最长无重复子串_3

import scala.collection.mutable

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var max = 0
    var cnt = 0
    val map = mutable.HashMap[Char, Int]()
    s.zipWithIndex.foreach { case (c, index) => {
      if (!map.contains(c)) map.put(c, index)
      else {
        cnt = math.min(cnt, index - map(c) - 1)
        map.put(c, index)
      }
      cnt += 1
      max = math.max(cnt, max)
    }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("tmmzuxt"))
  }
}
