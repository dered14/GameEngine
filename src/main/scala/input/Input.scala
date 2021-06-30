package input

import input.hardwareInput;
import input.hardwareInput.InputReader
import scala.collection.mutable;
import input.packegeObj.*


/* Multiple keys can trigger the same Input
   e.g. The 'D' and 'Rightarrow' keys may both trigger the 'MoveRight' input*/

class Input (keys:Set[hardwareInput.InputId]) {

    val id = Input.nextId()

    // takes the values of the hardware inputs and computes the value of the abstract input
    def getValue(inputs:Map[hardwareInput.InputId, InputValue]):InputValue = {
        val keyValues = keys.map(k => inputs.get(k).getOrElse(NoVal))
        val value = keyValues.find(k => k != NoVal)
        value.getOrElse(NoVal);
    }
}

object Input {
    private var id = 0;

    private def nextId() = {
        Input.id += 1;
        Input.id - 1
    }
}