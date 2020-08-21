package xiaoyu.algostruct.offer.栈的压入和弹出序列_31

import scala.collection.mutable

object Solution {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val stack = new mutable.Stack[Int]()
    var i = 0
    pushed.foreach(num => {
      stack.push(num)
      while (stack.nonEmpty && i < popped.length && popped(i) == stack.head) {
        stack.pop()
        i += 1
      }
    })
    stack.isEmpty
  }

  def main(args: Array[String]): Unit = {

  }

}
