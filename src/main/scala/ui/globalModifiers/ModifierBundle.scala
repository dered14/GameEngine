package ui.globalModifiers

import ui.base
import ui.renderers.Renderer
import scala.collection.concurrent.TrieMap

import ui.globalModifiers.Modifier

class ModifierBundle {

    private var _globalModifiers = TrieMap.empty[ModifierId, Modifier]

    def add(m:Modifier) =  _globalModifiers(m.id) = m

    def globalModifiers:Iterator[Modifier] = _globalModifiers.valuesIterator

    def apply(renderer:Renderer) = {
        _globalModifiers.valuesIterator.foreach(m => renderer.applyModifier(m))
    }

    def apply(elem:base.UIElement) = {
        _globalModifiers.valuesIterator.foreach(m => elem.applyModifier(m))
    }

}