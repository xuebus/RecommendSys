/**
  * Created by wwy on 16/10/22.
  */
class Test {

}


object Test {
    try {

        val f = new FileReader("input.txt")
    } catch {
        case ex: FileNotFoundException => {
            println("Missing file exception")
        }
        case ex: IOException => {
            println("IO Exception")
        }
    } finally {

        println("Exiting finally...")
    }
}