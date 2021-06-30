/**
 *  Copyright (C) 2021, Stephan-Alexander Ariesanu.
 *  Do not copy or distribute this code.
 *  All rights reserved.
 */

package input.hardwareInput


import scala.collection.concurrent;
import scala.collection.concurrent.TrieMap

import input.packegeObj.InputValue


class HardwareInputStorage {

    private val map = new TrieMap[InputId, Double]
    private var snapshot:Map[InputId, InputValue] = Map.empty;

    def get(i:InputId):Option[InputValue] = map.get(i);

    def set(i:InputId, v:InputValue):Unit = map.put(i, v)

    def createSnapshot():Map[InputId, InputValue] = {
        snapshot = map.readOnlySnapshot.toMap
        snapshot
    }

    def getAll:Map[InputId, InputValue] = snapshot

}
