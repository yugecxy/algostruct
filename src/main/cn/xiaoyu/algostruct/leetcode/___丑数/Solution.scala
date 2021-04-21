package cn.xiaoyu.algostruct.leetcode.___丑数

object Solution {
  def isUgly(n: Int): Boolean = {

    def doDivisor(n: Int): Boolean = {
      if (n == 0) return false
      if (n == 1) return true
      if (n % 2 != 0 && n % 3 != 0 && n % 5 != 0) return false

      var res = false
      if (n % 2 == 0) res = res || doDivisor(n / 2)
      if (n % 3 == 0) res = res || doDivisor(n / 3)
      if (n % 5 == 0) res = res || doDivisor(n / 5)
      res
    }

    doDivisor(n)
  }

  def main(args: Array[String]): Unit = {
    println(isUgly(0))
  }
}
