/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.base

import ui.base
import ui.globalModifiers.settings.SettingBundle

import ui.globalModifiers.settings.Setting
import ui.globalModifiers.Modifier


trait UIElement {

    private var _scale = 1;
    def scale:Int = _scale
    def scale_=(newVal:Int):Unit = _scale = newVal

    def update():Unit

    def redraw():Unit

    def applyModifier(m:Modifier):Unit //visitor
}


object UIElement {

}