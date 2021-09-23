package mypackage

import com.twitter.algebird.Semigroup

object Maven {
  val message = Semigroup.plus("hello ", "world")
}

object RulesScalaIssue1291Repro {
  // This is the method that is reproducing https://github.com/bazelbuild/rules_scala/issues/1291.
  // If you comment the method's implementation and replace it with `true`, no error will thrown.
  // Run `bazel coverage //...` to reproduce the issue.
  def getMyValue(literal: String): Boolean =
    literal match {
      case s if s == "true" => true
      case s if s == "false" => false
      case _ => throw new Exception("Boooom!")
    }
}
