load("//tools:scala_version.bzl", "scala_binary_suffix")

scala_library(
    name = "example-maven",
    srcs = glob(["src/main/scala/**/*.scala"]),
    format = True,
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_twitter_algebird_core_%s" % scala_binary_suffix,
        "@maven//:org_typelevel_algebra_%s" % scala_binary_suffix,
        "@maven//:org_typelevel_cats_kernel_%s" % scala_binary_suffix,
    ],
)

scala_test(
    name = "test",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["example-maven"],
)
