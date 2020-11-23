package xiaoyu.algostruct.accumulate.区间覆盖问题之最大不相交覆盖

object Solution {

  def compute(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if (intervals.isEmpty) return intervals

    val sorted = intervals.sortBy(_ (0))
    sorted.foldLeft(Array[Array[Int]]())((b, a) => {
      if (b.isEmpty) b ++ Array(a)
      else {
        val tail = b.last
        if (a.head >= tail.last) b ++ Array(a)
        else {
          if (a.last > tail.last) b else b.slice(0, b.length - 1) ++ Array(a)
        }
      }
    })
  }

  def main(args: Array[String]): Unit = {
    val data = Array(
      Array(6, 8),
      Array(2, 4),
      Array(3, 5),
      Array(1, 5),
      Array(5, 9),
      Array(8, 10)
    )
    compute(data).map(_.toSeq).foreach(println(_))
  }

}
