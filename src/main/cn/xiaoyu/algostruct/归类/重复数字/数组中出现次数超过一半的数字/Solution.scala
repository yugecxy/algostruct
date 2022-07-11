package cn.xiaoyu.algostruct.归类.重复数字.数组中出现次数超过一半的数字

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
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