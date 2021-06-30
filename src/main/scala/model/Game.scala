package model

import scala.collection.mutable
import scala.annotation.targetName

class Game(val width:Int, val height:Int) {



    private val _elements = mutable.ListBuffer.empty[GameElement];

    def elements:Iterator[GameElement] = _elements.iterator

    @targetName("addContent")
    def += (component:GameElement):Unit = _elements.addOne(component)

    @targetName("addContent")
    def += (components:Iterable[GameElement]):Unit = _elements.addAll(components)

}