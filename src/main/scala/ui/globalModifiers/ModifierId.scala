package ui.globalModifiers

import ui.globalModifiers.settings.SettingId

enum ModifierId(m:ModifierIdSpecifier) {
    case setting(s:SettingId) extends ModifierId(s)
    case skin extends ModifierId(DefaultId)
}

class ModifierIdSpecifier

object DefaultId extends ModifierIdSpecifier
