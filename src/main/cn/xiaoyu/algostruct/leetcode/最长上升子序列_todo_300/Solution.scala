package cn.xiaoyu.algostruct.leetcode.最长上升子序列_todo_300

/**
  * 暂时超过时间限制
  */
object Solution {

  def lengthOfLIS(nums: Array[Int]): Int = {
    0
  }

  //递归的写法（暴力法，先用0，1方法列出所有可能，然后计算max）
  def lengthOfLIS2(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    var max = 0

    def recursive(i: Int, pre: Int, cnt: Int): Unit = {
      if (i >= nums.length) {
        max = math.max(max, cnt)
        return
      }
      if (nums(i) > pre) {
        recursive(i + 1, nums(i), cnt + 1)
      }
      recursive(i + 1, pre, cnt)
    }

    recursive(0, Int.MinValue, 0)
    max
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLIS(Array(0, 1, 0, 3, 2, 3)))
  }
}
