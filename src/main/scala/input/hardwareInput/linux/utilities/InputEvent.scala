/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

 package input.hardwareInput.linux.utilities

import input.hardwareInput.InputId

case class InputEvent(seconds:Long, millis:Long, _type:Long, code:Long, value:Long) {

        def getNormalizedValue:Double = {
            value.toDouble //TODO
        }

        def getInputId:Option[InputId] = {
            if(isMisc) {
                None
            }
            else{
                keyCodeToId
            }
        }

        def isMisc:Boolean = _type == 4

        def keyCodeToId:Option[InputId] = {
            code match {
                case 0x12F => Some(InputId.GamepadButtonLeft)
                case 0x130 => Some(InputId.GamepadButtonBottom)
                case 0x131 => Some(InputId.GamepadButtonRight)
                case 0x132 => Some(InputId.GamepadButtonTop)

                case 0x220 => Some(InputId.DpadVertical)
                case 0x221 => Some(InputId.DpadVertical)
                case 0x222 => Some(InputId.DpadHorizontal)
                case 0x223 => Some(InputId.DpadHorizontal)
                case 0x10  => Some(InputId.DpadHorizontal)
                case 0x11  => Some(InputId.DpadVertical)

                case _ => None
            }
        }
    }