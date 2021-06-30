/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package input.hardwareInput

import scala.collection.mutable

import input.hardwareInput.InputReader

object InputRegistrar {

    private val inputReaders = mutable.Set.empty[InputReader]

    private[hardwareInput] def register(r:InputReader) = inputReaders.add(r)

    def closeAll() = {
        inputReaders.foreach(r => r.close())
        inputReaders.clear
    }
}
