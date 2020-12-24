package cn.xiaoyu.algostruct.accumulate.位运算.找出只出现过一次的数字

/**
  * 如果除了一个数字以外，其他数字都出现了两次，那么如何找到出现一次的数字？
  * 全员求异或即可
  */
object Solution {

  def find(arr: Array[Int]): Int = {
    arr.reduce((a, b) => a ^ b)
  }

  def main(args: Array[String]): Unit = {
    println(find(Array(2,4,1,4,2)))
  }

}
