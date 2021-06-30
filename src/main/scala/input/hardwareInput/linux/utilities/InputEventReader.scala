/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

 package input.hardwareInput.linux.utilities

import java.io.{File,FileInputStream}

import java.nio.{ByteBuffer, ByteOrder}

import utils.Math.{pow, byteMaxVal}

class InputEventReader(private val inputFile:File) {

    private val buffer = ByteBuffer.allocate(InputEventSizes.input_event_size)
    private val deviceChannel = new FileInputStream(inputFile).getChannel;

    def getNext() = {
        deviceChannel.read(buffer)
        val evValues = getEventValues()
        buffer.clear
        InputEvent(
            evValues(0),
            evValues(1),
            evValues(2),
            evValues(3),
            evValues(4)
        )
    }

    private def buildLong(buffOffset:Int, numBytes:Int, endiannes:ByteOrder) = {
        var res:Long = 0
        for(i <- 0 until numBytes) {
            val exp = if(endiannes.equals(ByteOrder.LITTLE_ENDIAN)) {i} else {numBytes - i}
            val b = buffer.get(buffOffset + i);
            if( exp != numBytes - 1 || b >= 0) {
                val unsignedB = if(b < 0) {b + 256} else { b + 0 }
                res = res + unsignedB * pow(byteMaxVal + 1, exp)
            }
            else{
                val noFirstByte = b + 128;
                res = res + noFirstByte * pow(byteMaxVal + 1, exp)
                res = res - 128 * pow(byteMaxVal + 1, exp)
            }
        }
        res
    }

    private def getEventValues() = {
        val offsets = InputEventSizes.sizes.tail.foldLeft(Array[Int](0)) ((a,i) => a :+ (a.last + i))
        val offsetsAndSizes = offsets.zip(InputEventSizes.sizes.tail)
        val mapped = offsetsAndSizes.map((o,s) => buildLong(o, s, ByteOrder.nativeOrder))
        mapped
    }

    def closeChannel() = {
        deviceChannel.close
    }

}
