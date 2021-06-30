/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.base


trait Screen[Elem <: ScreenElement] extends UIContainer[Elem] with UIElement{

    private var _dimensions = (1, 1);
    def dimensions:(Int,Int) = _dimensions
    def dimensions_=(newVal:(Int,Int)):Unit = _dimensions = newVal

    def display():Unit

    def dispose():Unit

    def center():Unit

    def applyModifier(m: ui.globalModifiers.Modifier): Unit

    def redraw():Unit

}