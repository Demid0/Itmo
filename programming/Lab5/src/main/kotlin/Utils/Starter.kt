package Utils

import CollectionObjectsClasses.Route
import Serialization.*
import java.io.*
import kotlin.system.exitProcess

class Starter {
    fun start(tank: Tank) {
        //last functional condition
        downloadLastSystemCondition(tank)

        //saved data
        downloadCollection(tank.data, tank.serializator)
    }
    fun downloadCollection(data: Data, serializator: Serializator) {
        println("Downloading collection")
        try {
            val file = File(data.getFileName())
            val reader = InputStreamReader(file.inputStream())
            val collection = ArrayDeque<Route>()
            for (str in reader.readLines()) {
                collection.add(serializator.deserialize(str))
            }
            data.collection = collection
        } catch (e: Exception) {
            println("File not found")
            exitProcess(1)
        }
        println("Done!")
    }

    fun downloadLastSystemCondition(tank: Tank) {
        println("Downloading last system condition")
        try {
            val file = File(tank.data.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()
            tank.data.changeType(output[0])
            tank.serializator.changeStrategy(tank.serializator.getStrategy(output[1])!!)
            println("Done!")
        } catch (e: Exception) {
            println("Can't found info about last system condition. Will use default serialization strategy and default collection type.")
        }
    }

}