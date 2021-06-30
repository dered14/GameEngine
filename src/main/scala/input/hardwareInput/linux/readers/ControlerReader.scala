/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package input.hardwareInput.linux.readers

import java.io.File

import java.nio.{ByteBuffer, Buffer}
import java.nio.channels.ClosedChannelException

import input.hardwareInput.{HardwareInputStorage, InputId, InputReader}
import input.hardwareInput.linux.utilities.InputEventReader
import input.packegeObj.InputValue



class ControlerReader(target:HardwareInputStorage) extends InputReader(target){

    private var inputEventReader = getInputReader

    override def canStart():Boolean = {
        inputEventReader.isDefined
    }

    override def readNextInput():Option[(InputId, InputValue)] = {
        try{
            readNextRelevantInputEvent()
        }
        catch{
            case e:ClosedChannelException => None
        }
    }

    private def readNextRelevantInputEvent() = {
        var next = inputEventReader.get.getNext();
        while(!isInterrupted && next.isMisc) {
            next = inputEventReader.get.getNext();
        }
        next.getInputId.map(i => (i, next.getNormalizedValue))
    }

    private def getInputReader:Option[InputEventReader] = {
        val deviceDirPath = "/dev/input/by-id/"
        val deviceDir = new File(deviceDirPath)
        val deviceFiles = deviceDir.listFiles
        val file = deviceFiles.find(f => f.getName.matches(".*-event-joystick"))
        file.map(f => new InputEventReader(f))
    }

    override def close() = {
        if (inputEventReader.isDefined) {
            inputEventReader.get.closeChannel()
        }
        super.close()
    }
}
