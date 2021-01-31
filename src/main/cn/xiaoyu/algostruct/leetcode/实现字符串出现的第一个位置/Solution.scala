package cn.xiaoyu.algostruct.leetcode.实现字符串出现的第一个位置

/**
  * https://leetcode-cn.com/problems/implement-strstr/
  */
object Solution {

  def strStr(haystack: String, needle: String): Int = {
    if (needle == "") return 0
    if (needle.length > haystack.length) return -1
    haystack.indices.foreach(i => {
      val j = i + needle.length
      if (j <= haystack.length && haystack.substring(i, j) == needle) return i
    })
    -1
  }

  def main(args: Array[String]): Unit = {
    println(strStr("hello", "ll"))
  }
}
