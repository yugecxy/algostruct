package cn.xiaoyu.algostruct.offer.矩阵中的路径

/**
  * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
  */
object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.length
    val n = board.head.length

    def dfs(x: Int, y: Int, k: Int): Boolean = {
      if (k > word.length - 1) return true
      if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || board(x)(y) != word(k)) return false
      val tmp = board(x)(y)
      board(x)(y) = '/'
      val res = dfs(x - 1, y, k + 1) || dfs(x + 1, y, k + 1) || dfs(x, y - 1, k + 1) || dfs(x, y + 1, k + 1)
      board(x)(y) = tmp
      res
    }

    if (board.isEmpty) return false
    else {
      board.indices.foreach(x => {
        board.head.indices.foreach(y => {
          val res = dfs(x, y, 0)
          if (res) return true
        })
      })
    }
    false
  }
}
