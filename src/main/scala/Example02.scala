import scala.util.Success
import scala.util.parsing.combinator.JavaTokenParsers


/**
  * Created by koduki on 2016/04/06.
  */
object Example02 {
  def main(args: Array[String]): Unit = {
    println("Hello")
    GrammarParser02("I LOVE YOU")
    GrammarParser02("I LOVE MUSIC")
    GrammarParser02("WE LOVE YOU")
    GrammarParser02("WE LOVE MUSIC")
    GrammarParser02("HE LOVES YOU")
    GrammarParser02("HE LOVES MUSIC")
    GrammarParser02("SHE LOVES YOU")
    GrammarParser02("SHE LOVES MUSIC")
    GrammarParser02("HE LOVE YOU")
    GrammarParser02("HE LOVE MUSIC")
    GrammarParser02("SHE LOVE YOU")
    GrammarParser02("SHE LOVE MUSIC")
  }
}

object GrammarParser02 extends JavaTokenParsers {
  def third = s ~ v ~ o ^^ { case subj ~ verb ~ obj => println(subj + verb + obj) } |
    su ~ ve ~ o ^^ { case s ~ v ~ o => println(s + "\"" + v + "\"" + o) }

  def s = "I" | "WE"

  def su = "S?HE".r

  def ve = "LOVES"

  def v = "LOVE"

  def o = "YOU" | "MUSIC"

  def apply(s: String): Unit = {
    parseAll(third, s) match {
      case Success(_, _) => println("Success")
      case x => println("Failure: " + x)
    }
  }

}
