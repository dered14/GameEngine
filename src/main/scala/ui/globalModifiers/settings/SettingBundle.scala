package ui.globalModifiers.settings

import ui.base
import ui.renderers.Renderer
import scala.collection.concurrent.TrieMap
import ui.globalModifiers.ModifierBundle

class SettingBundle(settings:List[Setting])
extends ModifierBundle{

    settings foreach add //same as settings.foreach(s => this.add(s))
}