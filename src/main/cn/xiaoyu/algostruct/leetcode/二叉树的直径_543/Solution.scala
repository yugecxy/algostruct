package xiaoyu.algostruct.leetcode.二叉树的直径_543


object Solution {
  def minArray(numbers: Array[Int]): Int = {
    var i = 0
    var j = numbers.length - 1
    while (i < j) {
      val m = (i + j) / 2
      if (numbers(m) > numbers(j)) i = m + 1
      else if (numbers(m) < numbers(j)) j = m
      else j = j - 1
    }
    numbers(i)
  }

  def main(args: Array[String]): Unit = {

  }
}
