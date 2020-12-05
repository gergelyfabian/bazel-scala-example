scala_library(
    name = "example-lib",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
)

scala_test(
    name = "test",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["example-lib"],
    jacocorunner = "//tools:jacoco_coverage_runner_filegroup",
)
