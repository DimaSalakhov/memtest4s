version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.8"

mainClass in (Compile, run) := Some("server.Server")

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "6.40.0",
  "com.github.finagle" %% "finch-core" % "0.11.0-M4"
)

test in assembly := {}
assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.last endsWith "io.netty.versions.properties" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last contains "ChannelBuffer" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith "BUILD" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
assemblyJarName in assembly := "finagle-mem-test.jar"