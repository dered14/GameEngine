/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.base

import ui.base
import ui.globalModifiers.settings.SettingBundle
import model.GameElement
import utils.Position
import model.shapes.Shape
import java.awt.Color


trait ScreenElement(elem:GameElement) extends UIElement{

    def shape:Shape

    private var _position:Position = elem.position
    def position = _position
    def position_=(v:Position) = _position = v

    private var _color:Color = Color.red;
    def color = _color
    def color_=(v:Color) = _color = v
}