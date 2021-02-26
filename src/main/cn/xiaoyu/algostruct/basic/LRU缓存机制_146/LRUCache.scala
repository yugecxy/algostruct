class LRUCache(_capacity: Int) {

  import scala.collection.mutable

  private class HNode(var _key: Int, var _value: Int) {
    var prev: HNode = _
    var next: HNode = _

    def value: Int = _value

    def key: Int = _key

    def setValue(value: Int): Unit = _value = value

    override def toString: String = s"[${_key}, ${_value}]"
  }

  private val fakeHead = new HNode(0, 0)
  fakeHead.next = fakeHead
  fakeHead.prev = fakeHead

  private val hashMap: mutable.HashMap[Int, HNode] = mutable.HashMap.empty

  def get(key: Int): Int = {
    if (hashMap.contains(key)) {
      // 移动节点
      moveToHead(hashMap(key))
      hashMap(key).value
    }
    else -1
  }

  def put(key: Int, value: Int) {
    // 已有该 key
    if (hashMap.contains(key)) {
      hashMap(key).setValue(value)
      // 移动节点
      moveToHead(hashMap(key))
      return
    }
    val hNode = new HNode(key, value)
    if (hashMap.size == _capacity) {
      val deletedKey = deleteNode()
      hashMap.-=(deletedKey)
    }
    hashMap.+=(key -> hNode)
    addNode(hNode)
  }

  private def moveToHead(hNode: HNode): Unit = {
    if (fakeHead.prev != hNode) {
      // 将hNode节点抽取出来
      hNode.prev.next = hNode.next
      hNode.next.prev = hNode.prev
      addNode(hNode)
    }
  }

  private def addNode(hNode: HNode): Unit = {
    // 处理节点数为空的情况
    if (fakeHead.next == fakeHead && fakeHead.prev == fakeHead) {
      fakeHead.prev = hNode
      fakeHead.next = hNode
      hNode.next = fakeHead
      hNode.prev = fakeHead
      return
    }
    // 将hNode粘进头结点处
    hNode.next = fakeHead
    hNode.prev = fakeHead.prev
    // 打破头结点处原有的结构
    hNode.prev.next = hNode
    fakeHead.prev = hNode
  }

  // return key of deleted node
  private def deleteNode(): Int = {
    // 获取最旧的节点的键
    val oldKey = fakeHead.next.key
    // 切割最旧节点
    fakeHead.next = fakeHead.next.next
    fakeHead.next.prev = fakeHead
    // 返回key，让hashmap把该key的记录删掉
    oldKey
  }

}
