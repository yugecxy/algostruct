package cn.xiaoyu.algostruct.Integration.位运算.找出只出现过一次的数字

/**
  * 如果除了一个数字以外，其他数字都出现了两次，那么如何找到出现一次的数字？
  * 全员求异或即可。相同的数异或结果是0，而0异或一个的结果还是这个结果本身
  *
  * https://leetcode-cn.com/problems/single-number/
  */
object Solution {

  def find(arr: Array[Int]): Int = {
    arr.reduce((a, b) => a ^ b)
  }

  def main(args: Array[String]): Unit = {
    println(find(Array(2, 4, 4, 2, 6)))
  }

}
