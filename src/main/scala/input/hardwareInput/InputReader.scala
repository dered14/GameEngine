/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package input.hardwareInput

import java.awt.event.InputEvent

import input.hardwareInput.InputId
import input.packegeObj.InputValue

abstract class InputReader(target:HardwareInputStorage) extends Thread {

    override final def start():Unit = {
        if(canStart()) {
            setPriority(Thread.MAX_PRIORITY)
            InputRegistrar.register(this)
            super.start()
        }
    }

    protected def canStart():Boolean

    override final def run():Unit = {
        try while(!this.isInterrupted){
            updateTarget()
        }
        catch {
            case e:InterruptedException => ()
        }
    }

    private def updateTarget():Unit = {
        val next = readNextInput()
        if(next.isDefined){
            target.set(next.get._1, next.get._2)
        }
    }

    protected def readNextInput():Option[(InputId, InputValue)]

    def close() = interrupt()

}
