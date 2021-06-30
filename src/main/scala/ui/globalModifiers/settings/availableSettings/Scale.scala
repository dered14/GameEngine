/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package ui.globalModifiers.settings.availableSettings

import ui.globalModifiers.settings.Setting
import ui.globalModifiers.settings.SettingId
import ui.base.*

case class Scale(value:Int) extends Setting(SettingId.scale){

  override def apply(s:UIElement) = s.scale = value

  override def apply[A <: ScreenElement](root:Screen[A]) = root.scale = value

  def apply(b:Button):Unit = b.scale = value

}
