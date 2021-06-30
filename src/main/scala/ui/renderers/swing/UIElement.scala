/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.renderers.swing

import ui.base
import ui.globalModifiers.settings.SettingBundle



trait UIElement extends scala.swing.UIElement with base.UIElement {

    override def redraw():Unit = {
        repaint()
    }
}