package cn.xiaoyu.algostruct.offer.___字符串的排列

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
  */
object Solution {
  def permutation(s: String): Array[String] = {

    var ret = Array[String]()

    def dfs(x: Int, res: String, str: Array[Char]): Unit = {
      if (x == s.length) {
        ret :+= res
        return
      }

      val set = mutable.HashSet[Char]()
      str.indices.foreach(i => {
        if (str(i) != ',' && !set.contains(str(i))) {
          val tmp = str(i)
          str(i) = ','
          dfs(x + 1, res ++ tmp.toString, str)
          str(i) = tmp
          set.add(tmp)
        }
      })
    }

    dfs(0, "", s.toCharArray)

    ret
  }

  /**
    * @return 经典的求全排列的做法
    */
  def permutation2(s: String): Array[String] = {

    var ret = Array[String]()

    def dfs(x: Int, res: String, str: Array[Char]): Unit = {
      if (x == s.length) {
        ret :+= res
        return
      }
      str.indices.foreach(i => {
        if (str(i) != ',') {
          val tmp = str(i)
          str(i) = ','
          dfs(x + 1, res ++ tmp.toString, str)
          str(i) = tmp
        }
      })
    }

    dfs(0, "", s.toCharArray)

    ret
  }

  /**
    * @return 求所有子串
    */
  def permutation3(s: String): Array[String] = {
    var ret = Array[String]()

    def dfs(s: Array[Char], accuArr: Array[Char], index: Int): Unit = {
      if (index == s.length) {
        ret :+= accuArr.mkString
        return
      }

      dfs(s, accuArr :+ s(index), index + 1)
      dfs(s, accuArr, index + 1)
    }

    dfs(s.toCharArray, Array[Char](), 0)

    ret
  }

  /**
    * @return 求数组中和为某值的所有子数组
    */
  def permutation4(arr: Array[Int], sum: Int): Array[Array[Int]] = {
    var ret = Array[Array[Int]]()

    def dfs(arr: Array[Int], path: Array[Int], pathSum: Int, index: Int): Unit = {
      if (index == arr.length) {
        if (pathSum == sum) ret :+= path
        return
      }

      dfs(arr, path :+ arr(index), pathSum + arr(index), index + 1)
      dfs(arr, path, pathSum, index + 1)
    }

    dfs(arr, Array[Int](), 0, 0)

    ret
  }

  def main(args: Array[String]): Unit = {
    println(permutation4(Array(2, 3, 4, 5), 7).map(_.mkString(",")).toSeq)
  }
}
