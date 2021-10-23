SCALA_VERSION = "2_12"

scala_library(
    name = "example-maven",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_twitter_algebird_core_2_12",
        "@maven//:org_typelevel_algebra_2_12",
        "@maven//:org_typelevel_cats_kernel_2_12",
        "@maven//:com_github_pureconfig_pureconfig_%s" % SCALA_VERSION,
        "@maven//:com_github_pureconfig_pureconfig_core_%s" % SCALA_VERSION,
        "@maven//:com_github_pureconfig_pureconfig_generic_%s" % SCALA_VERSION,
        "@maven//:com_github_pureconfig_pureconfig_generic_base_%s" % SCALA_VERSION,
        "@maven//:com_github_pureconfig_pureconfig_macros_%s" % SCALA_VERSION,
        "@maven//:com_typesafe_config",
        "@maven//:com_chuusai_shapeless_%s" % SCALA_VERSION,
        "@maven//:org_typelevel_macro_compat_%s" % SCALA_VERSION,
        "@maven//:org_scala_lang_scala_library",
    ],
)

scala_test(
    name = "test",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = ["example-maven"],
)
