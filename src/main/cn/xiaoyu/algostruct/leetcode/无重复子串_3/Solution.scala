package xiaoyu.algostruct.leetcode.无重复子串_3

import scala.collection.mutable

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var max = 0
    var len = 0
    val map = new mutable.HashMap[Char, Int]()
    for (i <- s.indices) {
      len += 1
      val curChar = s(i)
      if (map.contains(curChar) && i - map(curChar) < len) {
        len = i - map(curChar)
      }
      map.put(curChar, i)
      max = math.max(len, max)
    }
    max
  }
}
