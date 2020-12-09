package cn.xiaoyu.algostruct.leetcode.接雨水_42


object Solution {

  def trap(height: Array[Int]): Int = {
    var total = 0
    var i = 0
    while (i < height.length) {
      var tmpI = i + 1
      if (i < height.length - 2 && height(i + 1) < height(i)) {
        var tmpMaxIndex = i + 1
        var j = i + 2
        while (height(tmpMaxIndex) < height(i) && j < height.length) {
          if (height(j) > height(tmpMaxIndex)) tmpMaxIndex = j
          j += 1
        }
        if (height(tmpMaxIndex) > height(i + 1)) {
          val areaAll = math.min(height(i), height(tmpMaxIndex)) * (tmpMaxIndex - i - 1)
          val areaDiff = height.slice(i + 1, tmpMaxIndex).sum
          total += areaAll - areaDiff
          tmpI = tmpMaxIndex
        }
      }
      i = tmpI
    }
    total
  }

  def main(args: Array[String]): Unit = {
    println(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
  }
}
