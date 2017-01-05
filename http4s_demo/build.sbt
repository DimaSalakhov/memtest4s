name := "http4s-demo"
version := "1.0-SNAPSHOT"
scalaVersion := "2.11.7"

val http4sVersion = "0.14.8a"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl"          % http4sVersion,
  "org.http4s" %% "http4s-argonaut"     % http4sVersion
)

test in assembly := {}
assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.last endsWith "io.netty.versions.properties" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
assemblyJarName in assembly := "http4s-mem-test.jar"