import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wwy on 16-11-6.
  */
class TotalSum {

}

object TotalSum{

    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setAppName("totalSum").setMaster("local")
        val sc = new SparkContext(conf)
        val data = sc.textFile("/home/wwy/桌面/data/out").map(_.split("\t"))

        val all = data.map(_.drop(1)(0)).map(_.toDouble)
        var res = 0.0
        for(value <- all){


            println("uuuuu")
            res += value
            println(res)

        }
        println("---------------------")
        println(res)
        println("---------------------")


    }


}



