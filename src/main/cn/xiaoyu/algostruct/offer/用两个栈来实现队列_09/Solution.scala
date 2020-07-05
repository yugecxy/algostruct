package xiaoyu.algostruct.offer.用两个栈来实现队列_09

import scala.collection.mutable.Stack

class CQueue() {
  val stack1 = new Stack[Int]()
  val stack2 = new Stack[Int]()

  def appendTail(value: Int) {
    stack1.push(value)
  }

  def deleteHead(): Int = {
    if (stack2.nonEmpty) {
      stack2.pop()
    }
    else if (stack1.isEmpty) -1
    else {
      while (stack1.nonEmpty) {
        stack2.push(stack1.pop())
      }
      stack2.pop()
    }
  }
}