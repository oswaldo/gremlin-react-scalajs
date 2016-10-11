import sbt.Project.projectToRef

lazy val clients = Seq(scalajsclient)
lazy val scalaV = "2.11.8"

scalacOptions in Test ++= Seq("-Yrangepos")

lazy val playserver = (project in file("play")).settings(
  scalaVersion := scalaV,
  scalaJSProjects := clients,
  pipelineStages in Assets := Seq(scalaJSPipeline),
  compile in Compile <<= (compile in Compile) dependsOn scalaJSPipeline,
  pipelineStages := Seq(digest, gzip),
  libraryDependencies ++= Seq(
    "com.vmunier" %% "scalajs-scripts" % "1.0.0",
    "com.lihaoyi" %% "scalatags" % "0.5.5",
    "org.webjars" % "jquery" % "3.0.0",
    "com.github.japgolly.scalacss" %% "core" % "0.4.1",
    "com.github.japgolly.scalacss" %% "ext-scalatags" % "0.4.1",
    "org.specs2" %% "specs2-junit" % "3.8.5" % "test",
    "com.typesafe.play" %% "play-specs2" % "2.5.9"
  ),
  EclipseKeys.preTasks := Seq(compile in Compile)
).enablePlugins(PlayScala).
  aggregate(clients.map(projectToRef): _*).
  dependsOn(sharedJvm)

lazy val scalajsclient = (project in file("scalajs")).settings(
  scalaVersion := scalaV,
  persistLauncher := true,
  persistLauncher in Test := false,
  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.1",
    "com.lihaoyi" %%% "scalatags" % "0.5.5",
    "com.github.japgolly.scalajs-react" %%% "core" % "0.11.1",
    "com.github.japgolly.scalajs-react" %%% "extra" % "0.11.1",
    "com.github.japgolly.scalacss" %%% "core" % "0.4.1",
    "com.github.japgolly.scalacss" %%% "ext-scalatags" % "0.4.1",
    "com.github.japgolly.scalacss" %%% "ext-react" % "0.4.1"
  ),
  jsDependencies ++= Seq(
    "org.webjars.npm" % "react"     % "0.14.2" / "react-with-addons.js" commonJSName "React"    minified "react-with-addons.min.js",
    "org.webjars.npm" % "react-dom" % "0.14.2" / "react-dom.js"         commonJSName "ReactDOM" minified "react-dom.min.js" dependsOn "react-with-addons.js"
  )
).enablePlugins(ScalaJSPlugin, ScalaJSWeb).
  dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
  settings(scalaVersion := scalaV).
  jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

// loads the Play project at sbt startup
onLoad in Global := (Command.process("project playserver", _: State)) compose (onLoad in Global).value

// for Eclipse users
EclipseKeys.skipParents in ThisBuild := false


fork in run := true
