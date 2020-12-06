package xiaoyu.algostruct.leetcode.单词搜索_79

object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {

    def recursive(i: Int, j: Int, k: Int, board: Array[Array[Char]]): Boolean = {
      if (i < 0 || i >= board.length || j < 0 || j >= board.head.length || board(i)(j) == '.' || board(i)(j) != word(k)) return false
      if (k == word.length - 1) return true

      val tmp = board(i)(j)
      board(i)(j) = '.'
      val ret = recursive(i + 1, j, k + 1, board) || recursive(i, j + 1, k + 1, board) || recursive(i - 1, j, k + 1, board) || recursive(i, j - 1, k + 1, board)
      board(i)(j) = tmp
      ret
    }

    if (board.length == 0 || board.head.length == 0) return false
    board.indices.foreach(x => {
      board.head.indices.foreach(y => {
        val ret = recursive(x, y, 0, board)
        if (ret) return true
      })
    })
    false
  }
}