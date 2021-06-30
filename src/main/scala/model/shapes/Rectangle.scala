package model.shapes

import ui.renderers.Renderer


case class Rectangle(width:Int, height:Int) extends Shape {

     def boxDimensions:(Int, Int) = (width, height)
}