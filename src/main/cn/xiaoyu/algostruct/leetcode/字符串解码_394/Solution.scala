package xiaoyu.algostruct.leetcode.字符串解码_394

object Solution {

  def decodeString(s: String): String = {
    def compute(start: Int): (Int, String) = {
      var index = start

      var res = ""
      while (index < s.length) {
        val cur = s(index)
        if (cur == 'n') res += compute(index)
        else if (cur == ']') res += res * 3
        else res += cur.toString
      }
      (2, res)
    }
    ""
  }

  def main(args: Array[String]): Unit = {
    println(decodeString(")()())"))
  }
}
