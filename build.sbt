import org.scalajs.linker.interface.ModuleSplitStyle

val Versions = new {
  val Scala = "3.2.1"
  val Indigo = "0.14.0"
}

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin, SbtIndigo)
  .settings(
    name := "pongdigo",
    showCursor := true,
    title := "Pong with Indigo",
    gameAssetsDirectory := "assets",
    windowStartWidth := 720,
    windowStartHeight := 480,
    scalaVersion := Versions.Scala,
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("pongdigo"))
        )
    },
    scalacOptions += {
      val a = baseDirectory.value.toURI.toString
      val g = "../../../"
      s"-scalajs-mapSourceURI:$a->$g/"
    },
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "indigo" % Versions.Indigo,
      "io.indigoengine" %%% "indigo-extras" % Versions.Indigo,
      "io.indigoengine" %%% "indigo-json-circe" % Versions.Indigo
    )
  )
