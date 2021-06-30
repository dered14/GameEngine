ThisBuild / scalaVersion := "3.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

buildDependenciesAtStartup()

def buildDependenciesAtStartup() = {
    import sys.process._

    lazy val startupTransition: State => State = { s: State =>
        "./external/init.sh" !; s
    }

    onLoad in Global := {
        val old = (onLoad in Global).value
        // compose the new transition on top of the existing one
        // in case your plugins are using this hook.
        startupTransition compose old
    }
}


lazy val initExternalDependencies = taskKey[Unit]("Initializes all dependencies")
initExternalDependencies := () -> {
    import sys.process._
    "./external/init.sh" !
}
