package cn.xiaoyu.algostruct.test


object Solution {

  def main(args: Array[String]): Unit = {
    for (i <- 1000 until 2000) //定义外层循环,求一千以内的质数,循环输出从2到999,1000可直接舍弃
      if (i == 2 || i == 3) //如果当i=2和3,直接打印
        println(i)
      else if (ss(i)) //调用判断i是否是质数的方法,当i非2和3的时候开始判定,是的话就打印输出
        println(i)

    def ss(i: Int): Boolean = { //定义判断传入参数是否是质数的函数 返回布尔型值
      for (j <- 2 until i) { //内层循环,使j的值从2循环到传入的i的值而非i,然后依次判断i/j是否有余数,
        if ((i % j) == 0) //只要能被整除那就一定不是质数,所以结束函数
          return false
      }
      true //循环结束都不能被整除的就一定是质数,返回true
    }
  }
}
