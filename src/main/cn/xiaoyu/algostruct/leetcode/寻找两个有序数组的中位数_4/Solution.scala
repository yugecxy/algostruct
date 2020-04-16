package xiaoyu.algostruct.leetcode.寻找两个有序数组的中位数_4


object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]) = {
    var aStart = 0
    var bStart = 0
    var cnt = 0
    var left = 0.0
    var right = 0.0
    val len = nums1.length + nums2.length
    val middle_index = len / 2

    while (cnt <= middle_index) {
      left = right
      if (bStart >= nums2.length || (aStart < nums1.length && nums1(aStart) < nums2(bStart))) {
        right = nums1(aStart)
        aStart += 1
      } else {
        right = nums2(bStart)
        bStart += 1
      }
      cnt += 1
    }
    if ((len % 2) == 0) (left + right) / 2.0 else right
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
  }
}
