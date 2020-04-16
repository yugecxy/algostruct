package xiaoyu.algostruct.algorithm.sort.merge_sort

import scala.collection.mutable.ArrayBuffer

/**
  * 归并排序
  * 时间复杂度：O(nlogn)
  * 稳定性：稳定
  * 空间复杂度：O(n)
  *
  */
object Solution {

  /**
    * 合并两个有序的数组
    */
  def merge(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var i = 0
    var j = 0
    val newArr = ArrayBuffer[Int]()
    var cnt = 0
    while (cnt < nums1.length + nums2.length) {
      if (j >= nums2.length || (i < nums1.length && (nums1(i) < nums2(j)))) {
        newArr.append(nums1(i))
        i += 1
      }
      else {
        newArr.append(nums2(j))
        j += 1
      }
      cnt += 1
    }

    newArr.toArray
  }

  def mergeSort(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val left = if (nums1.length == 1) nums1 else {
      val splits = nums1.splitAt(nums1.length / 2)
      mergeSort(splits._1, splits._2)
    }

    val right = if (nums2.length == 1) nums2 else {
      val splits = nums2.splitAt(nums2.length / 2)
      mergeSort(splits._1, splits._2)
    }

    merge(left, right)
  }

  def main(args: Array[String]): Unit = {
    mergeSort(Array(1, 15, 8, 10), Array(2, 5, 7, 9)).foreach(println(_))
  }
}
