package xiaoyu.algostruct.leetcode.三数之和_15

import scala.collection.mutable.ListBuffer

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val numSize = nums.length
    if (numSize < 3) return List[List[Int]]()
    val nums_sort = nums.sorted
    if (nums_sort.head > 0 || nums_sort.last < 0) return List[List[Int]]()

    val result = ListBuffer[List[Int]]()
    (0 until numSize - 2).foreach(i => {
      if (i == 0 || nums_sort(i - 1) != nums_sort(i)) { // i 如果与前一个相同，pass
        val target: Int = -nums_sort(i)
        var j = i + 1
        var k = numSize - 1

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
    })
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val ret = threeSum(Array(-1, 0, 1, 2, -1, -4))
    ret.foreach(println(_))
  }
}