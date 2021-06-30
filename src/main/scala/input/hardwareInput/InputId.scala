/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package input.hardwareInput

enum InputId(val name:String) {
    case GamepadButtonRight  extends InputId("GamepadButtonRight")
    case GamepadButtonLeft   extends InputId("GamepadButtonLeft")
    case GamepadButtonTop    extends InputId("GamepadButtonTop")
    case GamepadButtonBottom extends InputId("GamepadButtonBottom")
    case DpadVertical        extends InputId("DpadVertical")
    case DpadHorizontal      extends InputId("DpadHorizontal")
}
