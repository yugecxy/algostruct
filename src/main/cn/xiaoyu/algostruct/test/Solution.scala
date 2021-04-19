package cn.xiaoyu.algostruct.test

object Solution {

  def merge(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    var i = 0
    var j = 0
    var cnt = 0
    val newArr = new Array[Int](arr1.length + arr2.length)
    while (cnt < arr1.length + arr2.length) {
      if (i >= arr1.length || (j < arr2.length && arr1(i) > arr2(j))) {
        newArr(cnt) = arr2(j)
        j += 1
      } else {
        newArr(cnt) = arr1(i)
        i += 1
      }
      cnt += 1
    }
    newArr
  }

  def mergeSort(arr: Array[Int]): Array[Int] = {
    if (arr.length == 1) return arr
    val midIndex = (arr.length - 1) / 2

    merge(mergeSort(arr.slice(0, midIndex + 1)), mergeSort(arr.slice(midIndex + 1, arr.length)))
  }

  def main(args: Array[String]): Unit = {
    println(mergeSort(Array(2, 1)).toSeq)
  }
}
