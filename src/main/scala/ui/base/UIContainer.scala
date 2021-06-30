package ui.base

import scala.collection.mutable
import scala.annotation.targetName

trait UIContainer[Elem <: ScreenElement] {

    private val _elements = mutable.ListBuffer.empty[Elem];
    private var list = _elements.toList

    def commitElements() = {
        list = _elements.toList
        _elements.clear
    }

    def elements:Iterator[Elem] = list.iterator

    def clear():Unit = _elements.clear()

    @targetName("addContent")
    def += (component:Elem):Unit = _elements.addOne(component)

    @targetName("addContent")
    final def += (components:Iterable[Elem]):Unit = {
        components.foreach(c => this += c)
    }
}