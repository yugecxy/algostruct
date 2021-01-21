package cn.xiaoyu.algostruct.offer.___和为s的两个数字

/**
  * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
  */
object Solution {

  /**
    * 时间复杂度O(n)，空间复杂度O(1)
    */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var i = 0
    var j = nums.length - 1
    while (i < j) {
      val sum = nums(i) + nums(j)
      if (sum > target) {
        j = j - 1
      }
      else if (sum < target) {
        i = i + 1
      }
      else {
        return Array(nums(i), nums(j))
      }
    }
    Array()
  }
}
