package ui.globalModifiers.skins

import ui.base.*
import java.awt.Color

object Default extends Skin {

    def apply(s: ui.base.UIElement): Unit = {
        throw new IllegalStateException("Called on Illegal type")
    }

    def apply[A <: ScreenElement](s: ui.base.Screen[A]): Unit = {
        s.elements.foreach(e => e.applyModifier(this))
    }

    def apply(b:Button):Unit = {
        b.color = Color.blue
        if(b.highlighted)
            applyHighlight(b)
    }

    private def applyHighlight(b:Button):Unit = {
        b.color = Color.red
    }
}