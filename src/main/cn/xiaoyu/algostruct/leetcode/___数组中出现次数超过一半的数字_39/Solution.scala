package cn.xiaoyu.algostruct.leetcode.___数组中出现次数超过一半的数字_39

import scala.collection.mutable

/**
  * 最佳解法：摩尔投票法 时间:O(n) 空间复杂度:O(1)
  */
object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    val map = new mutable.HashMap[Int, Int]()
    if (nums.length == 1) return nums.head
    var i = 0
    while (i < nums.length) {
      if (map.contains(nums(i))) {
        if (map(nums(i)) >= nums.length / 2) return nums(i) else map.put(nums(i), map(nums(i)) + 1)
      } else {
        map.put(nums(i), 1)
      }
      i += 1
    }
    -1
  }

}