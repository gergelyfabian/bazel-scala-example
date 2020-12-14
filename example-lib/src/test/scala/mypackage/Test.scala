package mypackage

import org.scalatest._

class TestSuite extends FlatSpec {
  "things" should "work" in {
    assert(Foo.message == "hello world")
  }

  "call lambda test" should "work" in {
    assert(Foo.testLambdas(1) == List(10))
    assert(Foo.testLambdas(11) == List(30))
    Foo.main(List("").toArray)
  }
}
