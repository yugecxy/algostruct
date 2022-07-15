package cn.xiaoyu.algostruct.归类.字符串.最长回文字符串

/**
  * https://leetcode-cn.com/problems/longest-palindromic-substring/
  */
object Solution {

  def longestPalindrome(s: String): String = {
    var ret = ""
    s.indices.foreach(t => {
      val i, j = t
      val a = getLongest(i, j + 1, s)
      val b = getLongest(i - 1, j + 1, s)
      ret = Seq(ret, a, b).maxBy(_.length)
    })
    ret
  }

  def getLongest(i: Int, j: Int, s: String): String = {

    var l = i
    var r = j
    while (l >= 0 && r <= s.length - 1 && s(l) == s(r)) {
      l -= 1
      r += 1
    }
    //(r - 1 < l + 1)偶数并且第一次就没有匹配成功的情况
    if (r - 1 < l + 1) s(l).toString else s.substring(l + 1, r)
  }


  def main(args: Array[String]): Unit = {
    println(longestPalindrome("km"))
  }
}
