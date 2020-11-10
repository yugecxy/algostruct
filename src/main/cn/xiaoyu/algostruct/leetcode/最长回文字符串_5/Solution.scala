package xiaoyu.algostruct.leetcode.最长回文字符串_5

object Solution {

  def longestPalindrome(s: String): String = {
    if (s.length < 2) return s
    var ret = ""
    val getMax = (a: String, b: String) => if (a.length > b.length) a else b
    s.indices.foreach(k => {
      if (k > 0 && k < s.length) {
        ret = getMax(ret, getLongest(k - 1, k + 1, s))
      }
      ret = getMax(ret, getLongest(k, k + 1, s))
    })
    ret
  }

  def getLongest(begin: Int, end: Int, s: String): String = {
    var i = begin
    var j = end
    while (i >= 0 && j <= s.length - 1 && s(i) == s(j)) {
      i -= 1
      j += 1
    }
    s.substring(i + 1, j)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("km"))
  }
}
