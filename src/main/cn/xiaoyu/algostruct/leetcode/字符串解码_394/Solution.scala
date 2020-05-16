package xiaoyu.algostruct.leetcode.字符串解码_394

import scala.collection.mutable.Stack

object Solution {

  /**
    * 栈实现
    */
  def decodeString(s: String): String = {
    val stack = new Stack[(Int, String)]()
    var multi = ""
    var res = ""
    for (c <- s) {
      if ('0' <= c && c <= '9') {
        multi += c
      }
      else if (c == '[') {
        stack.push((multi.toInt, res))
        multi = ""
        res = ""
      }
      else if (c == ']') {
        val (last_multi, last_str) = stack.pop()
        val curStr = res
        for (i <- 0 until last_multi - 1) {
          res += curStr
        }
        res = last_str + res
      } else {
        res += c
      }
    }
    res
  }

  /**
    * 递归实现
    */
  def decodeString2(s: String): String = {
    ""
  }

  def main(args: Array[String]): Unit = {
    println(decodeString("3[a]2[b4[F]c]"))
  }
}
