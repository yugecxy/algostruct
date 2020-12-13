package cn.xiaoyu.algostruct.offer.数值的整数次方

/**
  * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
  */
object Solution {

  def myPow(x: Double, n: Int): Double = {
    if (x == 1) return 1
    if (x == -1) {
      if (n % 2 == 0) return 1 else return -1
    }
    if (n == -2147483648) return 0 //对于-2147483648，math.abs的结果还是负数，因为这是最大的负数范围了
    var i = 1
    var res = 1D
    while (i <= math.abs(n) && res != 0) { //res != 0 考察的是例如输入的case(0.0001 233242532)
      res *= x
      i += 1
    }
    if (n < 0) 1 / res else res
  }
}
