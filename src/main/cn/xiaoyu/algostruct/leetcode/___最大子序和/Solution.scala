package cn.xiaoyu.algostruct.leetcode.___最大子序和

/**
  * https://leetcode-cn.com/problems/maximum-subarray/
  */
object Solution {

  def maxSubArray(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var sum = 0
    nums.foreach(x => {
      sum = math.max(sum + x, x)
      max = math.max(sum, max)
    })
    max
  }

}
