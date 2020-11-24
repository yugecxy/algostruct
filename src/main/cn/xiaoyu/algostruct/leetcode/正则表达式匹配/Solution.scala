package xiaoyu.algostruct.leetcode.正则表达式匹配

/**
  * 待做
  */
object Solution {
  def isMatch(s: String, p: String): Boolean = {
    def recursive(i: Int, j: Int): Boolean = {
      if (i == s.length && j == p.length) return true
      if (i >= s.length && j < p.length) return false
      if (i < s.length && j >= p.length) return false
      if (p.charAt(j) != '*' && p.charAt(j) != '.') {
        if (p.charAt(j) != s.charAt(i)) false
        else {
          recursive(i + 1, j + 1)
        }
      } else {
        if (p.charAt(j) == '.') recursive(i + 1, j + 1)
        else {
          false
        }
      }
    }

    recursive(0, 0)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aab", "c*a*b"))
  }
}
