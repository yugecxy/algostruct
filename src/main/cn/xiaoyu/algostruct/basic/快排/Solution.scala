package cn.xiaoyu.algostruct.basic.快排

import scala.collection.mutable.ArrayBuffer

object Solution {

  def quitSort(arr: Array[Int]): Array[Int] = {
    if (arr.length == 1) return arr
    val pivot = arr.last
    val lArr = ArrayBuffer[Int]()
    val rArr = ArrayBuffer[Int]()
    Range(0, arr.length - 1).foreach(i => {
      if (arr(i) <= pivot) lArr.append(arr(i)) else rArr.append(arr(i))
    })
    Array.concat(quitSort(lArr.toArray), Array(pivot), quitSort(rArr.toArray))
  }

  def main(args: Array[String]): Unit = {
    println(quitSort(Array(4, 8, 1, 5, 2)).toSeq)
  }
}
