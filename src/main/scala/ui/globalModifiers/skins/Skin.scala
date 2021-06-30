package ui.globalModifiers.skins

import ui.base.*
import ui.globalModifiers.Modifier
import ui.globalModifiers.ModifierId

trait Skin extends Modifier{

    override final def id = ModifierId.skin

    def apply(b:Button):Unit

}