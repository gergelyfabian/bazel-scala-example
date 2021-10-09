load(
    "@io_bazel_rules_scala//scala:scala_maven_import_external.bzl",
    _scala_maven_import_external = "scala_maven_import_external",
)

repositories = [
    "https://jcenter.bintray.com/",
    "https://repo.maven.apache.org/maven2",
]

def scala_jars(artifacts):
    for key, artifact in artifacts.items():
        _scala_maven_import_external(
            name = key,
            artifact = artifact["artifact"],
            artifact_sha256 = artifact["sha256"],
            licenses = ["notice"],
            server_urls = repositories,
            deps = artifact.get("deps", []),
            runtime_deps = artifact.get("runtime_deps", []),
            testonly_ = artifact.get("testonly", False),
            fetch_sources = True,
        )
