/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package main


import engine.Engine
import ui.globalModifiers.settings.DefaultSettings

import ui.renderers.swing.SwingRenderer

import input.InputBridge
import input.hardwareInput.InputId.*

@main def launch():Unit = {
    val inputBridge = new InputBridge;
    val titleScreen = TitleScreenCreator.create(inputBridge)
    val game = new Engine(inputBridge, SwingRenderer, titleScreen)
    game.launch();

}
