package xiaoyu.algostruct.offer.数值的整数次方_16

/**
  * 该题主要考察对边界条件的考虑
  */
object Solution {

  def myPow(x: Double, n: Int): Double = {
    if (x == 1) return 1
    if (x == -1) {
      if (n % 2 == 0) return 1 else return -1
    }
    if (n == -2147483648) return 0
    var i = 1
    var res = 1D
    while (i <= math.abs(n) && res != 0) {
      res *= x
      i += 1
    }
    if (n < 0) 1 / res else res
  }
}
