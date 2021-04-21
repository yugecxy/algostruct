package cn.xiaoyu.algostruct.leetcode.___最长无重复子串

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
  */
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    if (s == "") return 0
    var max = Int.MinValue
    var cnt = 0
    val map = mutable.HashMap[Char, Int]()
    s.zipWithIndex.foreach { case (c, index) => {
      cnt += 1
      if (!map.contains(c)) map.put(c, index)
      else {
        cnt = math.min(cnt, index - map(c))
        map.put(c, index)
      }
      max = math.max(cnt, max)
    }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("tmmzuxt"))
  }
}
