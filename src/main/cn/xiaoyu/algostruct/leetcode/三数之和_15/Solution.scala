package xiaoyu.algostruct.leetcode.三数之和_15

import scala.collection.mutable.ListBuffer

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val result = ListBuffer[List[Int]]()
    val nums_size = nums.length
    if (nums.length >= 3) {
      val nums_sort = nums.sorted
      for (i <- 0 until nums_size - 2) {
        if (nums_sort(i) <= 0 && nums_sort(nums_size - 1) >= 0) {
          if (i == 0 || nums_sort(i - 1) != nums_sort(i)) { // i 如果与前一个相同，pass
            val target: Int = -nums_sort(i)
            var j = i + 1
            var k = nums_size - 1

            while (j < k) {
              if (nums_sort(j) + nums_sort(k) == target) {
                result += List[Int](nums_sort(i), nums_sort(j), nums_sort(k))
                j += 1 // 指针后移一位
                k -= 1
                while (j < k && nums_sort(j) == nums_sort(j - 1)) { //如果和前面一位相等那不用算了，已经有了
                  j += 1
                }
                while (j < k && nums_sort(k) == nums_sort(k + 1)) {
                  k -= 1
                }
              } else if (nums_sort(j) + nums_sort(k) > target) {
                k -= 1 //大于target,right应该向左移动
              } else if (nums_sort(j) + nums_sort(k) < target)
                j += 1 //小于target,left应该向右移动
            }
          }
        }
      }
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val ret = threeSum(Array(-1, 0, 1, 2, -1, -4))
    ret.foreach(println(_))
  }
}