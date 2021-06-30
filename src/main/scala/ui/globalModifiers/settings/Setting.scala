/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.globalModifiers.settings

import ui.base
import ui.globalModifiers.Modifier
import ui.globalModifiers.ModifierId

abstract class Setting(_id:SettingId) extends Modifier {

    override def id = ModifierId.setting(_id)
}
