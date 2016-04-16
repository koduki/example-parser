import scala.util.Success
import scala.util.parsing.combinator.JavaTokenParsers


/**
  * Created by koduki on 2016/04/06.
  */
object Example01 {
  def main(args : Array[String]) : Unit = {
    println("Hello")
    GrammarParser("I LOVE YOU")
    GrammarParser("I LOVE MUSIC")
    GrammarParser("WE LOVE YOU")
    GrammarParser("WE LOVE MUSIC")
  }
}

private object GrammarParser extends JavaTokenParsers {
  def third = s ~ v ~ o ^^ {case subj ~ verb ~ obj => println(subj + verb + obj)}
  def s = "I" | "WE"
  def v = "LOVE"
  def o = "YOU"|"MUSIC"

  def apply(s: String):Unit = {
    parseAll(third, s) match{
      case Success(_, _) => println("Success")
      case x => println("Failure: " + x)
    }
  }

}
