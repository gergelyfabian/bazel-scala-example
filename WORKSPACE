workspace(name = "scala_example")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

protobuf_version = "30.1"

http_archive(
    name = "com_google_protobuf",
    repo_mapping = {"@com_google_absl": "@abseil-cpp"},
    sha256 = "1451b03faec83aed17cdc71671d1bbdfd72e54086b827f5f6fd02bf7a4041b68",
    strip_prefix = "protobuf-%s" % protobuf_version,
    url = "https://github.com/protocolbuffers/protobuf/archive/refs/tags/v%s.tar.gz" % protobuf_version,
)

http_archive(
    name = "rules_java",
    sha256 = "d31b6c69e479ffa45460b64dc9c7792a431cac721ef8d5219fc9f603fa2ff877",
    urls = [
        "https://github.com/bazelbuild/rules_java/releases/download/8.11.0/rules_java-8.11.0.tar.gz",
    ],
)

load("@rules_java//java:rules_java_deps.bzl", "rules_java_dependencies")

rules_java_dependencies()

# Note that `rules_java` 8.x suggests loading `protobuf_deps()` after
# `rules_java_dependencies` and before `rules_java_toolchains()`:
# - https://github.com/bazelbuild/rules_java/releases/tag/8.9.0
load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

load("@rules_shell//shell:repositories.bzl", "rules_shell_toolchains")

rules_shell_toolchains()

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

# Import rules_jvm_external before rules_scala (to ensure rules_scala's dependencies don't override e.g. rules_jvm_external).

RULES_JVM_EXTERNAL_TAG = "6.7"

RULES_JVM_EXTERNAL_SHA = "a1e351607f04fed296ba33c4977d3fe2a615ed50df7896676b67aac993c53c18"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazel-contrib/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

register_toolchains(
    "//tools/jdk:java21_toolchain_definition",
)

#RULES_SCALA_VERSION = "6.6.0"
RULES_SCALA_VERSION = "84e3f449011cc2aca7f518ddd8dc7f25a46f8515"

http_archive(
    name = "rules_scala",
    integrity = "sha256-gSI7xKWPLmwvRLUyBGPi6GyT06jz16SUifbbVQdRgbI=",
    strip_prefix = "rules_scala-%s" % RULES_SCALA_VERSION,
    #url = "https://github.com/bazelbuild/rules_scala/releases/download/v%s/rules_scala-v%s.tar.gz" % (RULES_SCALA_VERSION, RULES_SCALA_VERSION),
    url = "https://github.com/bazelbuild/rules_scala/archive/{}.zip".format(RULES_SCALA_VERSION),
)

# Note: We are dependent on latest versions of rules_scala dependencies (e.g. rules_proto).
# If necessary, change to minimal versions (deps.bzl), and specify those dependencies explicitly where we need a higher version.
load("@rules_scala//scala:latest_deps.bzl", "rules_scala_dependencies")

rules_scala_dependencies()

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

http_archive(
    name = "rules_python",
    sha256 = "2cc26bbd53854ceb76dd42a834b1002cd4ba7f8df35440cf03482e045affc244",
    strip_prefix = "rules_python-1.3.0",
    url = "https://github.com/bazel-contrib/rules_python/releases/download/1.3.0/rules_python-1.3.0.tar.gz",
)

load("@rules_python//python:repositories.bzl", "py_repositories", "python_register_toolchains")

py_repositories()

load("@rules_java//java:repositories.bzl", "rules_java_toolchains")

rules_java_toolchains()

load("@rules_scala//:scala_config.bzl", "scala_config")
load("//tools:scala_version.bzl", "scala_binary_suffix", "scala_binary_version", "scala_version")

scala_config(scala_version = scala_version)

load("@rules_scala//scala:toolchains.bzl", "scala_register_toolchains", "scala_toolchains")

scala_toolchains(
    fetch_sources = True,
    jmh = True,
    junit = True,
    scalafmt = True,
    scalatest = True,
    specs2 = True,
)

scala_register_toolchains()

register_toolchains("//tools/jdk:my_scala_toolchain")

register_toolchains("//tools/jdk:scalafmt_toolchain")

python_register_toolchains(
    name = "python3_12",
    # Available versions are listed in @rules_python//python:versions.bzl.
    # We recommend using the same version your team is already standardized on.
    python_version = "3.12",
    register_coverage_tool = True,
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

http_archive(
    name = "rules_pkg",
    sha256 = "b7215c636f22c1849f1c3142c72f4b954bb12bb8dcf3cbe229ae6e69cc6479db",
    urls = [
        "https://github.com/bazelbuild/rules_pkg/releases/download/1.1.0/rules_pkg-1.1.0.tar.gz",
    ],
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")
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
        "org.scalameta:scalafmt-core_%s:3.8.3" % scala_binary_version,
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
