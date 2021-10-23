package mypackage

import com.twitter.algebird.Semigroup
import pureconfig._
import pureconfig.generic.auto._

object Maven {
  val message = Semigroup.plus("hello ", "world")

  def main(args: Array[String]): Unit = {
    val app = loadConfigOrThrow[AppConf]
    println(s"app = ${app}")
  }
}

case class AppConf(i: Int, a: A)
case class A(x: B)
case class B(x: C)
case class C(x: D)
case class D(x: E)
case class E(x: F)
case class F(x: G)
case class G(x: H)
case class H(x: Int)
