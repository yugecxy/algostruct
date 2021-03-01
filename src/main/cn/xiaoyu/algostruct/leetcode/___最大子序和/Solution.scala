package cn.xiaoyu.algostruct.leetcode.___最大子序和

object Solution {

  def maxSubArray(nums: Array[Int]): Int = {
    var sum = -1
    var maxValue = Int.MinValue
    nums.indices.foreach(i => {
      val cur = nums(i)
      sum = math.max(sum + cur, cur)
      maxValue = math.max(sum, maxValue)
      println(111)
    })
    maxValue
  }

}
