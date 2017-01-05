import scala.concurrent._
import ExecutionContext.Implicits.global

object Main extends App {
  println("Memory: " + ((Runtime.getRuntime.totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024)) + "mb")
  scala.io.StdIn.readChar()
}