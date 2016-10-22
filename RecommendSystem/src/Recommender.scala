import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wwy on 16/10/22.
  */
class Recommender {

}


object Recommender{


    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setAppName("test").setMaster("local")
        val sc = new SparkContext(conf)
        val data = sc.textFile()



    }


}



