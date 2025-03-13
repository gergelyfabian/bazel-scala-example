package mypackage

import com.google.protobuf.CodedOutputStream

object Maven {
  def repro(): Unit = {
    val result = new Array[Byte](0)
    CodedOutputStream.newInstance(result)
  }
}
