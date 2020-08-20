package xiaoyu.algostruct.offer.包含min函数的栈_30

class Node(x: Int, _minValue: Int) {
  var next: Node = null
  var prev: Node = null
  var minValue: Int = _minValue
  var value: Int = x
}

class MinStack {
  var cur: Node = null
  var preMinValue: Int = Int.MaxValue

  def push(x: Int) {
    if (cur == null) cur = new Node(x, x) else {
      val tmpMinValue = math.min(cur.minValue, x)
      val tmp = new Node(x, tmpMinValue)
      cur.next = tmp
      tmp.prev = cur
      cur = tmp
    }
  }

  def pop() {
    cur = cur.prev
    if (cur != null) cur.next == null
  }

  def top(): Int = {
    cur.value
  }

  def min(): Int = {
    cur.minValue
  }
}

object x {
  def main(args: Array[String]): Unit = {
    var obj = new MinStack()
    obj.push(1)
    obj.push(-3)
    obj.push(3)
    obj.push(4)
    obj.pop()
    obj.pop()
    obj.pop()
   println(obj.min())
  }
}
