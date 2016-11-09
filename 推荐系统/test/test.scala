import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wwy on 16-11-6.
  */
class test {

}


object test{

    def main(args: Array[String]): Unit = {



////        Array.fill(10)(1.0).foreach(println(_))
//
//        for(i <- 0 until(10)){
//            println(""+i)
//        }

        val conf = new SparkConf().setAppName("test").setMaster("local")
        val context: SparkContext = new SparkContext(conf)
        val sc = context
        val data = sc.parallelize(List("all", "cdb0", "ghb", "uib"))
        val dict = data.zipWithIndex().collectAsMap()
        for (i <- dict){
            println(i)
        }
        println(dict)

        println("---------xxx-")
        val map = dict.map(x => {
             println(x._1)
            println(x._2)
            println("----------")
            (x._1 , x._2)
        })








    }




}

