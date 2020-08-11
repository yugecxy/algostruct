package xiaoyu.algostruct.offer.调整数组顺序使奇数在前_21

/**
  * 空间复杂度O(1)
  */
object Solution {
  def exchange(nums: Array[Int]): Array[Int] = {
    def swap(l: Int, r: Int): Unit = {
      val tmp = nums(l)
      nums(l) = nums(r)
      nums(r) = tmp
    }

    var l = 0
    var r = nums.length - 1
    while (l < r) {
      while (l < r && nums(l) % 2 == 1) l += 1
      while (l < r && nums(r) % 2 == 0) r -= 1
      swap(l, r)
    }
    nums
  }
}
