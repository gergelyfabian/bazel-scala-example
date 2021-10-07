package mypackage

import com.twitter.algebird.Semigroup
import cats.syntax.either._
import cats.syntax.traverse._
import cats.instances.list._
import cats.instances.either._

object Maven {
  val message = Semigroup.plus("hello ", "world")

  def reproIntelliJSequenceHighlightError: Either[Throwable, List[String]] = {
    val foo: List[Either[Throwable, String]] = List(
      new IllegalArgumentException("boom").asLeft,
      new IllegalArgumentException("baam").asLeft,
      "abc".asRight,
      "yxc".asRight
    )

    foo.sequence
  }
}
