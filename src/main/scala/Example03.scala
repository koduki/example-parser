import scala.util.Success
import scala.util.parsing.combinator.JavaTokenParsers


/**
  * Created by koduki on 2016/04/06.
  */
object Example03 {

  abstract class Expr

  case class Variable(name: String) extends Expr

  case class Number(value: Double) extends Expr

  case class UnaryOp(operator: String, arg: Expr) extends Expr

  case class BinaryOp(operator: String, left: Expr, right: Expr) extends Expr

  def main(args: Array[String]): Unit = {
    println("Hello")
    println(ArithParser("3*(1+2)").map(println))
  }
}

object ArithParser extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)

  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)

  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"


  def apply(text: String):ParseResult[Any] = {
    return parseAll(expr, text)
  }

}
