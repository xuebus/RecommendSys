import java.io.{FileOutputStream, PrintWriter}
import java.lang.Math._
/**
  * Created by wwy on 16-11-2.
  */
class DataGenerator {


}


//比例确认，如果有10000条记录，有一千个用户， 100个app
//默认应该是十万条记录 一万个用户 一千条记录 相应的作者应该是两百个
object DataGenerator {
    def main(args: Array[String]): Unit = {
        //        for(i <- 1 to 100){
        //            val str = new StringBuilder()
        //            for(i <- 1 to (100 * random()).toInt + 1){
        //                str.append("hitop_id").append((random() * 100000/100)toInt).append(",")
        //            }
        //            println(str)
        //        }

        val path = "/home/wwy/桌面/abc"
        var num = 1000
        makelist(num,path)
        makeappdown(num,path)
        makesample(num,path)

        println("运行结束了")

    }

    /**
      *
      *  hitop_id    STRING,
    name        STRING,
    author      STRING,
    sversion    STRING,
    ischarge    SMALLINT,
    designer    STRING,
    font        STRING,
    icon_count  INT,
    stars       DOUBLE,
    price       INT,
    file_size   INT,
    comment_num INT,
    screen      STRING,
    dlnum       INT
      */

    def makelist(num: Int, path: String): Unit ={

        val pw = new PrintWriter(new FileOutputStream(path + "/applist.txt"), true)
        val str = new StringBuilder()
        for(i <- 1 to num){
            str.clear()
            str.append("hitop_id").append((random()*num/100).toInt).append("\t")
            str.append("name").append((random()*num/100).toInt).append("\t")
            str.append("author").append((random()*num/500).toInt).append("\t")
            str.append("sversion").append((10*random()).toInt).append("\t")
            str.append((2*random()).toInt).append("\t")
            str.append("designer").append((random()*num/500).toInt).append("\t")
            str.append("font").append((20*random()).toInt).append("\t")
            str.append((10*random()).toInt).append("\t")
            str.append(f"${10*random()}%1.2f").append("\t")
            str.append((random()*num).toInt).append("\t")
            str.append((random()*num).toInt).append("\t")
            str.append((random()*num/50).toInt).append("\t")
            str.append("screen").append((random()*num/20).toInt).append("\t")
            str.append((random()*num/50).toInt)
            pw.write(str.toString());
            pw.println()
        }

        /**
          * flush()直面意思就是刷新printwriter流的缓冲区。
          * printwriter流如果和文件流(如Stream和Reader流)一起使用的话，
          * printwriter流首先是把程序中数据写入内存缓冲区，然后再由文件流写入文件。
          * 如果不刷新缓冲区的话，就一直暂用内存资源。
          */
        pw.flush()
        pw.close()

    }


    def makeapplist(num: Int): String = {
        val str = new StringBuilder()
        for(i <- 1 to (10 * random()).toInt + 1){
            str.append("hitop_id").append((random()*num/100).toInt).append(",")
        }
        str.deleteCharAt(str.length-1)
        return str.toString()


    }

    def makeappdown(num: Int, path: String): Unit ={
        val pw = new PrintWriter(new FileOutputStream(path+"/userdownload.txt", true))
        var str = new StringBuilder()
        for(i <- 1 to num){
            str.clear()
            str.append("device_id").append((random()*num/10).toInt).append("\t")
            str.append(makeapplist(num)).append("\t")
            str.append("device_name").append((random()*num/10).toInt).append("\t")
            str.append("pay_ability").append((4*random()).toInt)
            pw.write(str.toString());
            pw.println()
        }
        pw.flush()
        pw.close()


    }


    def makesample(num:Int,path:String): Unit ={
        val pw = new PrintWriter(new FileOutputStream(path+"/sample.txt",true))
        var str = new StringBuilder()
        for(i<-1 to num){
            str.clear()
            str.append(2*(2*random()).toInt-1).append("\t")
            str.append("device_id").append((random()*num/10).toInt).append("\t")
            str.append("hitop_id").append((random()*num/100).toInt).append("\t")
            str.append("screen").append((random()*20).toInt).append("\t")
            str.append("en_name").append((random()*num/100).toInt).append("\t")
            str.append("ch_name").append((random()*num/100).toInt).append("\t")
            str.append("author").append((random()*num/500).toInt).append("\t")
            str.append("sversion").append((10*random()).toInt).append("\t")
            str.append("mnc").append((random()*num/10).toInt).append("\t")
            str.append("event_local_time").append((random()*num).toInt).append("\t")
            str.append("interface").append((random()*num).toInt).append("\t")
            str.append("designer").append((random()*num/500).toInt).append("\t")
            str.append((2*random()).toInt).append("\t")
            str.append((10*random()).toInt).append("\t")
            str.append("update_date").append((random()*num).toInt).append("\t")
            str.append(f"${10*random()}%1.2f").append("\t")
            str.append((random()*num/50).toInt).append("\t")
            str.append("font").append((20*random()).toInt).append("\t")
            str.append((random()*num).toInt).append("\t")
            str.append((random()*num).toInt).append("\t")
            str.append((2*random()).toInt).append("\t")
            str.append((random()*num/50).toInt)
            pw.write(str.toString());
            pw.println()
        }
        pw.flush()
        pw.close()
    }




}




