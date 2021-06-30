package input

import scala.collection.mutable;

import input.hardwareInput.InputRegistrar
import input.hardwareInput.HardwareInputStorage;
import input.hardwareInput.linux.readers.ControlerReader
import input.packegeObj.*

class InputBridge extends InputObserver{

    private var abstractInputs = mutable.ListBuffer.empty[Input]
    private var inputStorage = new HardwareInputStorage

    startAllReaders()

    private def startAllReaders():Unit = {
        new ControlerReader(inputStorage).start()
    }

    def newAbstractInput(keys: Set[hardwareInput.InputId]):Input = {
        val input = new Input(keys);
        abstractInputs += input;
        input
    }

    def readAllInputs():Map[InputId, InputValue] = {
        val snapshot = inputStorage.createSnapshot();
        abstractInputs.map(absInput => {
            absInput.id -> absInput.getValue(snapshot)
        }).toMap;
    }

    def closeAllReaders():Unit = InputRegistrar.closeAll();

}