import java.io.PrintWriter

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.SparseVector
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.Map

/**
  * Created by wwy on 16-11-6.
  */
class Recommonder {

}

object Recommonder {


    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setAppName("test").setMaster("local")
        val sc = new SparkContext(conf)

        //按照\t做分割切分，得到的是label和features字符串
        val data = sc.textFile("/home/wwy/桌面/000001_0").map(_.split("\t"))


        //def drop(n: Int): Map[A, B]
        //返回丢弃前n个元素新集合
        //map表示一行数据
//        data.map(_.drop(1)(0).split(";"))
//        data.map(x => {
//            var feartures: Array[String]  = x.drop(1)(0).split(";")
//            feartures.map(_.split(":")(0))
//        })
        //distince()去重复

        //如果用map得到的是RDD[Array[String]], flatmap 可以压平，将Array里面String释放出来
        //这里的map实际上是把1去除
        //去得到特征的字典映射
        val features: RDD[String] = data.flatMap(_.drop(1)(0).split(";")).map(_.split(":")(0)).distinct()

        //转成map为了后面得到稀疏向量非零下标用
        val dict: Map[String, Long] = features.zipWithIndex().collectAsMap()

        //构建labelpoint
        val traindata = data.map(x => {

            //得到label，逻辑回归只支持0.0和1.0这里需要转换一下
            val label = x.take(1)(0) match {
                case "-1" => 0.0
                case "1" => 1.0
            }

            //获得当前样本的特征在map中的下标，这些下标的位置是非零的，值统一是1.0
            val index: Array[Int] = x.drop(1)(0).split(";").map(_.split(":")(0)).map(
                    fe => {
                        val index: Long = dict.get(fe) match {
                            case Some(n) => n
                            case None => 0
                        }
                        index.toInt
                    }
            )

            //创建一个所有元素是1.0的数组，作为稀疏向量非零元素集合
            val vector = new SparseVector(dict.size, index, Array.fill(index.length)(1.0))

            //构建LabelPoint
            new LabeledPoint(label, vector)

        })

        //模型训练，两个参数分别是迭代次数和步长
        val model = LogisticRegressionWithSGD.train(traindata, 10, 0.1)
        val weights = model.weights.toArray
        val map: Map[Long, String] = dict.map(x => {
            (x._2, x._1)
        })

        val pw = new PrintWriter("/home/wwy/桌面/data/out")
        for(i <- 0 until weights.length){
            val featureName = map.get(i) match {
                case Some(x) => x
                case None => ""
            }
            val result = featureName+"\t"+weights(i)
            pw.write(result)
            pw.println()
        }
        pw.flush()
        pw.close()


    }

}



