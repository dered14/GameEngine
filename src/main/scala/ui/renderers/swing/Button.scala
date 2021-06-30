/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.renderers.swing

import swing.{Button, Color, event}

import ui.globalModifiers.settings.{SettingBundle, Setting}

import model.shapes.Shape
import ui.base
import ui.renderers.swing
import utils.Position
import java.awt.Graphics2D
import java.awt.Color
import java.awt.Font

class Button(button:model.Button)
extends base.Button(button:model.Button) with ScreenElement with base.ScreenElement(button) {

    override def paint(g: Graphics2D): Unit = {
        super.paint(g)
        g.setColor(Color.black)
        g.drawString(button.text, awtShape.getX.toFloat, awtShape.getCenterY.toFloat)
    }


}
