workspace(name = "scala_example")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

skylib_version = "1.3.0"

http_archive(
    name = "bazel_skylib",
    sha256 = "74d544d96f4a5bb630d465ca8bbcfe231e3594e5aae57e1edbf17a6eb3ca2506",
    type = "tar.gz",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format(skylib_version, skylib_version),
        "https://github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format(skylib_version, skylib_version),
    ],
)

RULES_PYTHON_VERSION = "0.36.0"

http_archive(
    name = "rules_python",
    sha256 = "ca77768989a7f311186a29747e3e95c936a41dffac779aff6b443db22290d913",
    strip_prefix = "rules_python-%s" % RULES_PYTHON_VERSION,
    url = "https://github.com/bazelbuild/rules_python/releases/download/%s/rules_python-%s.tar.gz" % (RULES_PYTHON_VERSION, RULES_PYTHON_VERSION),
)

load("@rules_python//python:repositories.bzl", "py_repositories", "python_register_toolchains")

py_repositories()

python_register_toolchains(
    name = "python3_12",
    # Available versions are listed in @rules_python//python:versions.bzl.
    # We recommend using the same version your team is already standardized on.
    python_version = "3.12",
    register_coverage_tool = True,
)

# Add explicit rules_java version to avoid conflict between rules_jvm_external and rules_scala.
# See more at https://github.com/bazelbuild/rules_jvm_external/issues/1047.
http_archive(
    name = "rules_java",
    sha256 = "6f3ce0e9fba979a844faba2d60467843fbf5191d8ca61fa3d2ea17655b56bb8c",
    urls = [
        "https://github.com/bazelbuild/rules_java/releases/download/7.11.1/rules_java-7.11.1.tar.gz",
    ],
)

load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")

rules_java_dependencies()

rules_java_toolchains()

# Add explicit rules_license version to avoid conflict between rules_jvm_external and rules_pkg.
# See more at https://github.com/bazel-contrib/rules_jvm_external/issues/1244.
http_archive(
    name = "rules_license",
    sha256 = "26d4021f6898e23b82ef953078389dd49ac2b5618ac564ade4ef87cced147b38",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_license/releases/download/1.0.0/rules_license-1.0.0.tar.gz",
        "https://github.com/bazelbuild/rules_license/releases/download/1.0.0/rules_license-1.0.0.tar.gz",
    ],
)

RULES_SCALA_VERSION = "6.6.0"

http_archive(
    name = "io_bazel_rules_scala",
    integrity = "sha256-5zTu+VzybAFxVmvcJNg72Cva+Mp4c77GzpsNUkva8F0=",
    strip_prefix = "rules_scala-%s" % RULES_SCALA_VERSION,
    url = "https://github.com/bazelbuild/rules_scala/releases/download/v%s/rules_scala-v%s.tar.gz" % (RULES_SCALA_VERSION, RULES_SCALA_VERSION),
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")
load("//tools:scala_version.bzl", "scala_binary_suffix", "scala_binary_version", "scala_version")

scala_config(scala_version = scala_version)

load("@io_bazel_rules_scala//scala:scala.bzl", "rules_scala_setup", "rules_scala_toolchain_deps_repositories")

# Loads other rules Rules Scala depends on.
rules_scala_setup()

rules_scala_toolchain_deps_repositories()

register_toolchains("//tools/jdk:my_scala_toolchain")

# optional: setup ScalaTest toolchain and dependencies
load("@io_bazel_rules_scala//testing:scalatest.bzl", "scalatest_repositories", "scalatest_toolchain")

scalatest_repositories()

scalatest_toolchain()

load("@io_bazel_rules_scala//scala/scalafmt:scalafmt_repositories.bzl", "scalafmt_default_config", "scalafmt_repositories")

scalafmt_default_config()

register_toolchains("//tools/jdk:scalafmt_toolchain")

protobuf_version = "3.21.10"

protobuf_version_sha256 = "90de7e780db97e0ee8cfabc3aecc0da56c3d443824b968ec0c7c600f9585b9ba"

http_archive(
    name = "com_google_protobuf",
    sha256 = protobuf_version_sha256,
    strip_prefix = "protobuf-%s" % protobuf_version,
    url = "https://github.com/protocolbuffers/protobuf/archive/v%s.tar.gz" % protobuf_version,
)

http_archive(
    name = "zlib",
    build_file = "@com_google_protobuf//:third_party/zlib.BUILD",
    sha256 = "c3e5e9fdd5004dcb542feda5ee4f0ff0744628baf8ed2dd5d66f8ca1197cb1a1",
    strip_prefix = "zlib-1.2.11",
    urls = [
        "https://mirror.bazel.build/zlib.net/zlib-1.2.11.tar.gz",
        "https://zlib.net/zlib-1.2.11.tar.gz",
    ],
)

rules_pkg_version = "1.0.1"

http_archive(
    name = "rules_pkg",
    sha256 = "d20c951960ed77cb7b341c2a59488534e494d5ad1d30c4818c736d57772a9fef",
    urls = [
        "https://github.com/bazelbuild/rules_pkg/releases/download/%s/rules_pkg-%s.tar.gz" % (rules_pkg_version, rules_pkg_version),
    ],
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()

RULES_JVM_EXTERNAL_TAG = "6.3"

RULES_JVM_EXTERNAL_SHA = "c18a69d784bcd851be95897ca0eca0b57dc86bb02e62402f15736df44160eb02"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
load("@rules_jvm_external//:specs.bzl", "maven")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external_deps//:defs.bzl", rules_jvm_external_deps_pinned_maven_install = "pinned_maven_install")

rules_jvm_external_deps_pinned_maven_install()

maven_install(
    artifacts = [
        "junit:junit:4.12",
        "org.scalatest:scalatest_%s:3.0.8" % scala_binary_version,
        "com.twitter:algebird-core_%s:0.13.7" % scala_binary_version,
        "org.scala-lang:scala-library:jar:%s" % scala_version,
        "org.scala-lang:scala-reflect:jar:%s" % scala_version,
        "org.scala-lang:scala-compiler:jar:%s" % scala_version,
        "org.scalameta:scalafmt-core_%s:2.4.2" % scala_binary_version,
    ],
    # Some useful options that you may want to try:
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo.maven.apache.org/maven2",
    ],
    resolve_timeout = 1200,
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

register_toolchains("//tools/jdk:java21_toolchain_definition")
