package cn.xiaoyu.algostruct.leetcode.___最大子序和

/**
  * https://leetcode-cn.com/problems/maximum-subarray/
  */
object Solution {

  def maxSubArray(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var sum = 0
    nums.foreach(x => {
      if (sum < 0) sum = 0
      sum = sum + x
      max = math.max(sum, max)
    })
    return max
  }

}
