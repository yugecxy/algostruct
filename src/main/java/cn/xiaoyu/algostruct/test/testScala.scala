package cn.xiaoyu.algostruct.test

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

class ListNode(value_input: Int) {
  var x = value_input
  var next: ListNode = null
}

object testScala {
  def getListRes(iterator: Array[Int], loop: Array[Int]): List[List[Int]] = {

    val map = new mutable.HashMap[List[Int], String]()
    var res = List[List[Int]]()

    //负数取一个的case
    for (ite <- iterator) {
      val sum = ite * -1
      val findMap = new mutable.HashMap[Int, String]()
      breakable(for (lo <- loop) {
        if (!map.contains(List(ite, lo))) {
          val to = sum - lo
          if (!findMap.contains(to)) {
            findMap.put(lo, null)
          }
          else {
            res = res :+ List(ite, lo, to)
            map.put(List(ite, lo), null)
          }
        }
      }
      )
    }

    res
  }

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    var negs = nums.filter(_ < 0)
    var noNegs = nums.filter(_ >= 0)
    if (nums.length < 3) {
      return List()
    }
    if (!noNegs.exists(_ != 0)) {
      return List(List(0, 0, 0))
    }
    //负数取一个的case
    getListRes(negs, noNegs) ++ getListRes(noNegs, negs)
  }

  def main(args: Array[String]): Unit = {
    println(threeSum(Array[Int](-2, 0, 1, 1, 2)))
  }
}
