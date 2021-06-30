package model

import model.shapes.Rectangle
import ui.renderers.Renderer
import utils.Position

class Button extends GameElement {

    private var _highlighted:Boolean = false;
    def highlighted:Boolean = _highlighted

    def highlight():Unit = _highlighted = true
    def removeHighlight():Unit = _highlighted = false


    private var _text = "Test"
    def text:String = _text
    def text_=(newVal:String) = _text = newVal

    def renderBy(r:Renderer):r.ScreenElement = r.render(this)
}