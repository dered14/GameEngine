package model

import utils.Position
import model.shapes.Shape
import ui.renderers.Renderer
import model.shapes.Rectangle

abstract class GameElement {

    final val id = GameElement.nextId()

    private var _shape:Shape = Rectangle(50, 50)
    def shape:Shape = _shape
    def shape_=:(newVal:Shape) = _shape = newVal

    private var _position:Position = Position(0,0);
    def position = _position
    def position_=(v:Position) = _position = v

    def renderBy(r:Renderer):r.ScreenElement //visitor

    override def hashCode() = {
        return (id % Int.MaxValue).toInt;
    }

}

object GameElement {

    private var id:Long = 0;

    private def nextId() = {
        id += 1
        if(id == -1){
            throw new IllegalStateException(
                "The engine does not support more than Long many elements at once.\n" +
                "Use GameElement.resetIds() to recive a fresh batch of ids " +
                "(e.g. when changing the sceene)")
        }
        id - 1
    }
}