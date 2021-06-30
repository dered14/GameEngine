package input

import input.packegeObj.{InputValue, NoVal}
import scala.collection.concurrent.TrieMap
import scala.collection.mutable

trait InputObserver {

    //todo add mechanism to stop obseving

    type CallBack = InputValue=>Unit
    type InputId = Int

    private val callbacks = TrieMap.empty[InputId, mutable.ListBuffer[CallBack]]

    def registerObserver(observedInput:InputId, callback:InputValue=>Unit):Unit = {
        if(callbacks.contains(observedInput)) {
            callbacks(observedInput) += callback;
        }
        else{
            callbacks(observedInput) = mutable.ListBuffer(callback)
        }
    }

    def notifyObservers(observedInput:InputId, value:InputValue):Unit = {
        callbacks.getOrElse(observedInput, List.empty[CallBack]).foreach(f => f(value));
    }
}