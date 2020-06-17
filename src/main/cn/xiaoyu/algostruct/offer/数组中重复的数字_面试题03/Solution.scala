package xiaoyu.algostruct.offer.数组中重复的数字_面试题03

import scala.collection.mutable

object Solution {
  def findRepeatNumber(nums: Array[Int]): Int = {
    val set = mutable.HashSet[Int]()
    nums.foreach(num => {
      if (set.contains(num)) return num else set.add(num)
    })
    -1
  }

}
