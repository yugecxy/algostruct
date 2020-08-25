package xiaoyu.algostruct.offer.字符串的排列

import scala.collection.mutable

object Solution {
  def permutation(s: String): Array[String] = {

    val set = new mutable.HashSet[String]()

    def dfs(i: Int, accStr: String): Array[String] = {
      if (i == s.length) return if (set.contains(accStr)) Array() else {
        set.add(accStr)
        Array(accStr)
      }
      val iterators = s.diff(accStr).toArray
      iterators.flatMap(c => dfs(i + 1, accStr + c))
    }

    dfs(0, "")
  }

  def main(args: Array[String]): Unit = {
    println(permutation("aab").toSeq)
  }
}
