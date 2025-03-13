load("//tools:scala_version.bzl", "scala_binary_suffix")

scala_library(
    name = "example-maven",
    srcs = glob(["src/main/scala/**/*.scala"]),
    scalacopts = [
        "-opt-inline-from:**",
    ],
    deps = [
        #"@maven//:com_google_protobuf_protobuf_java",
        "@com_google_protobuf//:protobuf_java",
    ],
)

scala_test(
    name = "test",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["example-maven"],
)
