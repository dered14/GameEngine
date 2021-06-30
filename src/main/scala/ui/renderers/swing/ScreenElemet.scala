/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.renderers.swing

import ui.base
import ui.globalModifiers.settings.SettingBundle
import utils.Position

import swing.Swing.pair2Dimension
import java.awt.Graphics2D
import java.awt.Graphics
import java.awt.geom.Rectangle2D
import java.awt.geom.RectangularShape
import java.awt.Color
import ui.renderers.swing.SwingRenderer
import scala.swing.Label
import model.shapes.Rectangle


trait ScreenElement extends scala.swing.Panel with base.ScreenElement {

    private var _awtShape:RectangularShape = new Rectangle2D.Double(0, 0, 100, 100)
    def awtShape:RectangularShape = _awtShape
    def awtShape_=(newVal:RectangularShape):Unit = _awtShape = newVal

    private[swing] def setAWTShape():Unit = {
        awtShape = shape match {
            case Rectangle(width, height) =>
                new Rectangle2D.Double(position.x, position.y, scale*width, scale*height)
        }
    }

    override def redraw():Unit = {
        revalidate()
        repaint()
    }

    override def update():Unit = {
        setAWTShape()
    }

    override def paint(g: Graphics2D): Unit = {
        setAWTShape()
        g.setColor(color)
        g.fill(_awtShape)
    }

}