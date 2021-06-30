package ui.renderers

import ui.base

import model.*
import model.shapes.*

import ui.globalModifiers.settings.Setting
import ui.globalModifiers.{Modifier, ModifierBundle}
import ui.globalModifiers.settings.DefaultSettings
import ui.globalModifiers.skins.Default


trait Renderer {

    protected val globalModifiers:ModifierBundle = initGlobalModifiers

    protected def initGlobalModifiers:ModifierBundle = {
        val res = new ModifierBundle()
        DefaultSettings.globalModifiers.foreach(res.add)
        res.add(Default)
        res
    }

    type ScreenElement <: base.ScreenElement

    def applyModifier(m:Modifier):Unit

    final def render(elem:GameElement) = {}

    def render(game:Game):base.Screen[ScreenElement]

    def render(button:Button):base.Button & ScreenElement

    def update(game:Game):Unit

    def update(button:Button):Unit

    def stop():Unit
}