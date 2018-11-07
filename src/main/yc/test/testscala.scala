//package test
//
///**
//  * Created by chenxiaoyu
//  * Author: chenxiaoyu
//  * Date: 2018/5/3
//  * Desc:
//  *
//  */
//object testscala {
//  val spark=SparkSession.build
//  val source=spark.sparkConf.read.csv("")
////  source.select("Airport ID", "Country").
////    distinct().
////    groupby("Country").
////    count().
////    orderBy("Country").
////    take(3)
//
//
//  val result=source.select("Country","Airport ID").rdd.
//    distinct().
//    map(x=>(x._1,1)).
//    reduceBykey((a,b)=>a+b).
//    sortBy(-_._2).
//    take(3)
//
//  source.createOrReplaceView("tmp")
//  val sqlStr=
//    s"""
//       |select
//       |Country,
//       |cnt
//       |(
//       |select
//       |Country,
//       |count(distinct(Airport ID)) as cnt
//       |from
//       |tmp
//       |group by Country
//       |)
//       |where cnt >=5
//     """.stripMargin
//  val sqlStr2="select Country,count(distinct(Airport ID)) from tmp group by Country having count(distinct(Airport ID))>=5"
//  val res=spark.sql(sqlStr)
//
//
//}
