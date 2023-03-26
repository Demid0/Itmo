package utils

import org.koin.core.component.KoinComponent
import java.io.*
import kotlin.system.exitProcess
import org.koin.core.component.inject
import serializationStrategies.utils.Serializator

/***
 * Класс, загружающий последнее сохраненное состояние системы и коллекции
 * @author Demid0
 * @since 1.0
 */
class Starter: KoinComponent {

    fun downloadLastSystemCondition() {
        val data: Data by inject()
        val serializator: Serializator by inject()

        println("Downloading last system condition")
        try {
            val file = File(data.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()

            // Пробует десериализовать по последней стратегии, если не получается, то пробегается по всем возможным
            serializator.changeStrategy(serializator.getStrategy(output[1])!!)
            if (!downloadCollection(data, serializator)) {
                var flag = false
                for (strategy in serializator.getStrategies()) {
                    serializator.changeStrategy(strategy.value)
                    if (downloadCollection(data, serializator)) {
                        flag = true
                        break
                    }
                }
                if (flag) System.err.println("File was in ${serializator.getChosenStrategy().toString()} type.")
                else System.err.println("Collection didn't download")
            }

            serializator.changeStrategy(serializator.getStrategy(output[1])!!)

            data.changeType(output[0])
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
            println("Serialization strategy ${serializator.getChosenStrategy()} is not working.")
            return false
        }
        return true
    }

}