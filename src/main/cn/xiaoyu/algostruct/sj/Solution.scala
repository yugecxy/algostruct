package xiaoyu.algostruct.sj

object Solution {

  def compute(obj: Any): Any = {
    obj match {
      case _: Map[String, Any] => {
        obj.asInstanceOf[Map[String, Any]].map(x => (x._1, compute(x._2))).filter(x => x._2 match {
          case _: Map[String, Any] => x._2.asInstanceOf[Map[String, Any]].nonEmpty
          case _ => x._2 != ""
        })
      }
      case _: List[Any] => obj.asInstanceOf[List[Any]].map(x => compute(x)).filter(x => x match {
        case _: Map[String, Any] => x.asInstanceOf[Map[String, Any]].nonEmpty
        case _ => true
      })
      case _ => obj
    }
  }

  def main(args: Array[String]): Unit = {
    val a: Map[String, Any] = Map("name" -> "tom", "age" -> "", "info" -> List(Map("address" -> "hh", "kk" -> ""), Map("a" -> "")), "info2" -> Map("d" -> ""))
    val b = compute(a)
    println(b)

  }
}
