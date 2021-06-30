package ui.renderers.swing

import ui.renderers.swing
import ui.base

import ui.globalModifiers.settings.Setting

import model.*
import model.shapes.*
import scala.swing.Component

import java.awt.geom.Rectangle2D
import java.awt.geom.RectangularShape

import ui.renderers.Renderer
import ui.base.ScreenElement
import ui.globalModifiers.Modifier
import ui.globalModifiers.ModifierBundle
import ui.globalModifiers.settings.SettingBundle
import ui.globalModifiers.settings.DefaultSettings
import ui.globalModifiers.skins.Default
import scala.collection.mutable.Map

object SwingRenderer extends Renderer {

    override type ScreenElement = swing.ScreenElement

    private var root:swing.Screen = new swing.Screen;

    private val rederedElements:Map[GameElement, ScreenElement] = Map.empty

    override def applyModifier(m:Modifier):Unit = {
        m.apply[ScreenElement](root)
        globalModifiers.add(m);
    }

    def render(game:Game): swing.Screen = {
        root.dimensions = (game.width, game.height)
        game.elements.foreach(el => root += el.renderBy(this))
        root.commitElements()
        globalModifiers.apply(root)
        root
    }

    def render(button: Button): swing.Button = {
        val res = new swing.Button(button)
        rederedElements(button) = res
        res
    }


    def update(game:Game):Unit = {
        render(game)
        root.redraw()
    }

    def update(button:Button):Unit = {
        rederedElements(button).update()
    }

    override def stop() = root.dispose()

}
