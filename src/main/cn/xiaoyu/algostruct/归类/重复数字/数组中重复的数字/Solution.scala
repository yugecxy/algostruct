package cn.xiaoyu.algostruct.归类.重复数字.数组中重复的数字

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
  */
object Solution {
  def findRepeatNumber(nums: Array[Int]): Int = {
    val set = mutable.HashSet[Int]()
    nums.foreach(num => {
      if (set.contains(num)) return num else set.add(num)
    })
    -1
  }

}
