version := "1.0.0-SNAPSHOT"
scalaVersion := "2.11.7"

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(),
    test in assembly := {},
    assemblyMergeStrategy in assembly := {
      case PathList(ps @ _*) if ps.last endsWith "io.netty.versions.properties" => MergeStrategy.first
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },
    assemblyJarName in assembly := "play-mem-test.jar"
  )
  .enablePlugins(PlayScala)