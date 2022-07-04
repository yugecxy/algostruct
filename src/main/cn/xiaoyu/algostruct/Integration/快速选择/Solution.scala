package cn.xiaoyu.algostruct.Integration.快速选择

import scala.collection.mutable

object Solution {

  /**
    * 求无序数组中位数
    */
  def quitSelect(arr: Array[Int]): Int = {
    if (arr.length == 0) return -1
    if (arr.length == 1) return arr.head

    def merge(lArr: Array[Int], pivot: Int, rArr: Array[Int]): Array[Int] = {
      lArr ++ Array(pivot) ++ rArr
    }

    def doQuitSelect(arr: Array[Int], k: Int): Int = {
      val pivot = arr.last
      var lessArr = Array[Int]()
      var greaterArr = Array[Int]()
      Range(0, arr.length - 1).foreach(x => {
        var toAppendArr = if (arr(x) < pivot) lessArr else greaterArr
        toAppendArr ++= Array(arr(x))
      })

      if (lessArr.length == greaterArr.length) return pivot
      if (lessArr.length < greaterArr.length) return doQuitSelect(greaterArr, k - lessArr.length)
      else doQuitSelect(lessArr, k)
    }

    doQuitSelect(arr, arr.length / 2)
  }


  def main(args: Array[String]): Unit = {
    println(quitSelect(Array(1, 2, 3, 4, 5, 6)))
  }
}
