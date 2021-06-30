# GameEngine
A simple game engine writen in Scala

# Build

The project can be build using `sbt` (https://www.scala-sbt.org/)

Alternatively one can execute the `external/init.sh` script and any scala compiler compatible with scala 3 (https://docs.scala-lang.org/scala3/getting-started.html)

# Version

The project is in a WIP state. Most of the functionality is not jet implemented.

# Structure and Overview

## Model

A representation of the elements in the game.

## UI

Provides classes that can render the games described in the `model` package.

  - renderers: render the model using a specific GUI framework. Currently the only one available is `swing`
  - base: describe the UI elements that every renderer should be able to generate
  - globalModifieres: can be added to a renderer to change the aspect of the gui (change the scale, apply a skin, etc.)

## Input
Reads the input from the user in a pooling manner.

## Engine
Connects the components and launches the game

## Utils
Provides some classes and functtions of general use (exponentiation, positive modulo etc.)

## main

Can be used to do live testing of the project 



