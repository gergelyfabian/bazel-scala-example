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

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_PYTHON_VERSION = "0.28.0"

http_archive(
    name = "rules_python",
    integrity = "sha256-1wzXKnpIgPAACmNGJTQUglwZzdQKKCib32e45kgO3/g=",
    strip_prefix = "rules_python-%s" % RULES_PYTHON_VERSION,
    url = "https://github.com/bazelbuild/rules_python/releases/download/%s/rules_python-%s.tar.gz" % (RULES_PYTHON_VERSION, RULES_PYTHON_VERSION),
)

load("@rules_python//python:repositories.bzl", "py_repositories", "python_register_toolchains")

py_repositories()

python_register_toolchains(
    name = "python3_11",
    # Available versions are listed in @rules_python//python:versions.bzl.
    # We recommend using the same version your team is already standardized on.
    python_version = "3.11",
)

# Add explicit rules_java version to avoid conflict between rules_jvm_external and rules_scala.
# See more at https://github.com/bazelbuild/rules_jvm_external/issues/1047.
# Version was taken from rules_jvm_external/repositories.bzl (for Bazel 7).
http_archive(
    name = "rules_java",
    sha256 = "3121a00588b1581bd7c1f9b550599629e5adcc11ba9c65f482bbd5cfe47fdf30",
    urls = [
        "https://github.com/bazelbuild/rules_java/releases/download/7.3.2/rules_java-7.3.2.tar.gz",
    ],
)

# Using top of master (2024-04-08)
RULES_SCALA_VERSION = "800cd820a693275e918222c69be10d6238db6bdb"

http_archive(
    name = "io_bazel_rules_scala",
    integrity = "sha256-J2Ew+Wp9w1m8ZQVbEf1N7+WZhl5589Vcue7AepRZSfE=",
    strip_prefix = "rules_scala-%s" % RULES_SCALA_VERSION,
    #url = "https://github.com/bazelbuild/rules_scala/releases/download/v%s/rules_scala-v%s.tar.gz" % (RULES_SCALA_VERSION, RULES_SCALA_VERSION),
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.tar.gz" % RULES_SCALA_VERSION,
)

load("//tools:scala_version.bzl", "scala_binary_suffix", "scala_binary_version", "scala_version")
load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

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

rules_pkg_version = "0.9.1"

http_archive(
    name = "rules_pkg",
    sha256 = "8f9ee2dc10c1ae514ee599a8b42ed99fa262b757058f65ad3c384289ff70c4b8",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_pkg/releases/download/%s/rules_pkg-%s.tar.gz" % (rules_pkg_version, rules_pkg_version),
        "https://github.com/bazelbuild/rules_pkg/releases/download/%s/rules_pkg-%s.tar.gz" % (rules_pkg_version, rules_pkg_version),
    ],
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

# Using master temporarily.
RULES_JVM_EXTERNAL_VERSION = "6.0"

http_archive(
    name = "rules_jvm_external",
    integrity = "sha256-hf1rrVisdsw6J8jgUeQlX/nM2MkrqHlnDRlWIufAqbc=",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_VERSION,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_VERSION, RULES_JVM_EXTERNAL_VERSION),
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

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

register_toolchains("//tools/jdk:java17_toolchain_definition")
