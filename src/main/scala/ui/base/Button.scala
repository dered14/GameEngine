/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.base

import ui.globalModifiers.Modifier
import java.awt.Color


trait Button(button:model.Button) extends ScreenElement  {

    position = button.position
    def text = button.text
    def highlighted = button.highlighted
    override def shape = button.shape

    override def applyModifier(m:Modifier):Unit = m.apply(this)

}
