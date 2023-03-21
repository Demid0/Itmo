package Utils

import Serialization.*
import java.io.*
import kotlin.system.exitProcess

class Starter {

    fun downloadLastSystemCondition(tank: Tank) {
        println("Downloading last system condition")
        try {
            val file = File(tank.data.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()

            // Пробует десериализовать по последней стратегии, если не получается, то пробегается по всем возможным
            tank.serializator.changeStrategy(tank.serializator.getStrategy(output[1])!!)
            if (!downloadCollection(tank.data, tank.serializator)) {
                var flag = false
                for (strategy in tank.serializator.getStrategies()) {
                    tank.serializator.changeStrategy(strategy.value)
                    if (downloadCollection(tank.data, tank.serializator)) {
                        flag = true
                        break
                    }
                }
                if (flag) System.err.println("File was in ${tank.serializator.getChosenStrategy().toString()} type.")
                else System.err.println("Collection didn't download")
            }

            tank.serializator.changeStrategy(tank.serializator.getStrategy(output[1])!!)

            tank.data.changeType(output[0])
            println("Done!")
        } catch (e: Exception) {
            println("Can't found info about last system condition. Will use default serialization strategy and default collection type.")
        }
    }

    fun downloadCollection(data: Data, serializator: Serializator): Boolean {
        try {
            val file = File(data.getFileName())
            val reader = InputStreamReader(file.inputStream())
            data.collection = serializator.deserialize(reader.readText())
        } catch (e: FileNotFoundException) {
            println("File not found")
            exitProcess(1)
        } catch (e: Exception) {
            println("Serialization strategy ${serializator.getChosenStrategy()} not working.")
            return false
        }
        return true
    }

}