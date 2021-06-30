package ui.globalModifiers

import ui.base

trait Modifier{

    def id:ModifierId

    def apply(s:base.UIElement):Unit

    def apply[A <: base.ScreenElement](s:base.Screen[A]):Unit

    def apply(b:base.Button):Unit

}