/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package engine

import java.util.concurrent.atomic.AtomicBoolean

import model.Game

import input.packegeObj.*

import ui.base.Screen
import ui.globalModifiers.settings.DefaultSettings
import ui.renderers.Renderer

class Engine(inputs:InputBridge, renderer:Renderer, game:Game) {

    private val frameRate = 60
    private val frameIntervalMillis = 1000.0d / frameRate;
    private val closed = AtomicBoolean(false)

    private val screen = renderer.render(game)

    def launch():Unit = {
        screen.display()
        while (!closed.get) {
           executePeriodically(cycle, frameIntervalMillis)
        }
    }

    private def executePeriodically(f: ()=>Unit, duration:Double) = {
        //todo compute next frame instead of sleeping
        val startTime = System.currentTimeMillis;
        f()
        val cycleLength = System.currentTimeMillis - startTime;
        val timeToSleep = utils.Math.toPositiveLong(duration - cycleLength);
        Thread.sleep(timeToSleep);
    }

    private def cycle() = {
        val input = readInput()
        applyInput(input)
        updateUI()
    }

    private def readInput() = {
        inputs.readAllInputs()


    }

    private def applyInput(input:Map[InputId, InputValue]) = {
        input.foreach(i => inputs.notifyObservers(i._1, i._2))
    }

    private def updateUI() = {
        renderer.update(game)
    }

    def stop():Unit = {
        inputs.closeAllReaders()
        closed.set(true)
        renderer.stop()
    }
}
