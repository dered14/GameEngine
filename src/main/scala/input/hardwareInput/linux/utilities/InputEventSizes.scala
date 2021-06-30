/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

 package input.hardwareInput.linux.utilities

import sys.process._

import scala.language.postfixOps

object InputEventSizes {

    private val externalDeviceSizeReader = "./external/C/controlerDeviceSizes.o"

    // todo read those sizes during installation instead of during startup
    val sizes = getSizes()
    val input_event_size = sizes(0)
    val time_size_sec = sizes(1)
    val time_size_msec = sizes(2) // In addition to time_size_sec
    val type_size = sizes(3)
    val code_size = sizes(4)
    val value_size = sizes(5)


    private def getSizes():Array[Int] = {
        execDeviceSizeReader()
        .split("\n")
        .filter(s => !s.isBlank)
        .map(s => s.trim.toInt)
    }

    private def execDeviceSizeReader():String = {
        try{
            (externalDeviceSizeReader !!)
        }
        catch{
            case e:Exception => {
                System.err.println(s"Could not run process $externalDeviceSizeReader. Check the correctness of the external source")
                System.err.println("Causeb by:")
                System.err.println(e.getLocalizedMessage)
                System.exit(1)
            }
            ""
        }
    }
}