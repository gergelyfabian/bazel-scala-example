load("@rules_jvm_external//:defs.bzl", "java_export")

scala_library(
    name = "example-lib",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
)

scala_test(
    name = "test",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["example-lib"],
)

java_library(
    name = "hello-world",
    srcs = ["src/main/java/mypackage/Greeter.java"],
)

java_test(
    name = "java_test",
    srcs = [
        "src/test/java/mypackage/TestHello.java",
    ],
    test_class = "mypackage.TestHello",
    deps = ["hello-world"],
)

java_export(
    name = "hello-world-exported",
    srcs = ["src/main/java/mypackage/Greeter.java"],
    maven_coordinates = "com.mypackage:greeter:0.0.1",
    deps = [
        ":example-lib",
    ],
)
