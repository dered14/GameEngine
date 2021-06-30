/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.renderers.swing

import scala.annotation.targetName

import ui.base
import ui.renderers.swing
import ui.renderers.swing.SwingRenderer
import ui.globalModifiers.settings.SettingBundle

import scala.swing.Swing.pair2Dimension
import scala.swing.Graphics2D

class Screen extends base.Screen[swing.ScreenElement] {

    private val frame = new scala.swing.Frame() with scala.swing.RichWindow.Undecorated
    private val windowArea = new WindowArea(this)


    initContent()

    private def initContent() = frame.contents = windowArea

    override def redraw():Unit = {
        windowArea.validate();
        windowArea.repaint();
    }

    override def center() = frame.centerOnScreen()

    override def applyModifier(m: ui.globalModifiers.Modifier): Unit = m.apply(this)

    override def dispose() = frame.dispose()

    override def dimensions_=(newVal:(Int,Int)):Unit = {
        frame.size = (newVal._1 * scale, newVal._2 * scale)
        super.dimensions = (newVal)
    }

    override def scale_=(newVal:Int):Unit = {
        frame.size = (dimensions._1 * newVal, dimensions._2 * newVal)
        super.scale = (newVal)
    }

    def display(): Unit = frame.open()

    class WindowArea(container:base.UIContainer[swing.ScreenElement])
    extends scala.swing.Panel() {
        override def paintComponent(g:Graphics2D) = {
            super.paintComponent(g);
            container.elements
            container.elements.foreach(e => {
                e.paint(g)
            })
        }
    }

    override def update():Unit = {}


}