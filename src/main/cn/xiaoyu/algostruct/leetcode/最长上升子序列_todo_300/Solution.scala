package xiaoyu.algostruct.leetcode.最长上升子序列_todo_300

object Solution {

  def lengthOfLIS(nums: Array[Int]): Int = {
    var curMin = Int.MaxValue
    var res = 1
    for (i <- nums.indices) {
      val cur = nums(i)
      if (cur < curMin) {
        res = math.max(res, nums.slice(i + 1, nums.length).count(_ >= cur))
      }
      curMin = math.min(curMin, cur)
    }
    res
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLIS(Array(10,9,2,17,9,7,101,18)))
  }
}
