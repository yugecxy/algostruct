package cn.xiaoyu.algostruct.leetcode.__寻找重复数

object Solution {
  // 方法一：采用位图。时间复杂度O(n)，空间复杂度 O(n)
  def findDuplicate(nums: Array[Int]): Int = {
    val bitMap = new Array[Byte](nums.length)
    nums.foreach(num => {
      if (bitMap(num) == '1') return num
      bitMap(num) = '1'
    })
    -1
  }

  // 方法二: 采用快速选择算法。时间复杂度O(nlogn), 空间复杂度 O(1)
  def findDuplicate2(nums: Array[Int]): Int = {
    -1
  }

  // 方法三: 采用快慢指针。时间复杂度O(n), 空间复杂度 O(1)
  def findDuplicate3(nums: Array[Int]): Int = {
    -1
  }


  def main(args: Array[String]): Unit = {
    println(findDuplicate(Array(1, 1, 2, 3, 4)))
  }
}
