package mypackage

import cats.Traverse
import com.twitter.algebird.Semigroup
import cats.syntax.either._
import cats.syntax.traverse._
import cats.instances.list._
import cats.instances.either._

object Maven {
  val message = Semigroup.plus("hello ", "world")

  type MyEither[A] = Either[Throwable, A]

  def reproIntelliJSequenceHighlightError: MyEither[List[String]] = {
    val foo: List[Either[Throwable, String]] = List(
      new IllegalArgumentException("boom").asLeft,
      new IllegalArgumentException("baam").asLeft,
      "abc".asRight,
      "yxc".asRight
    )

    Traverse[List].sequence(foo)
  }
}
