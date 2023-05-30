package utils

import builders.printToClientPacket
import org.koin.core.component.KoinComponent
import java.io.*
import org.koin.core.component.inject

/***
 * Класс, загружающий последнее сохраненное состояние системы и коллекции
 * @author Demid0
 * @since 1.0
 */
class Starter: KoinComponent {
    private val serializator: Serializator by inject()
    fun downloadLastSystemCondition(collectionManager: CollectionManager) : Packet {
        try {
            val file = File(collectionManager.getInfoFileName())
            val reader = InputStreamReader(file.inputStream())
            val output = reader.readLines()

            // Пробует десериализовать по последней стратегии, если не получается, то пробегается по всем возможным
            serializator.changeStrategy(serializator.getStrategy(output[1])!!)
            if (!downloadCollection(collectionManager)) {
                for (strategy in serializator.getStrategies()) {
                    serializator.changeStrategy(strategy.value)
                    if (downloadCollection(collectionManager)) {
                        break
                    }
                }
            }
            serializator.changeStrategy(serializator.getStrategy(output[1])!!)
            collectionManager.changeType(output[0])

            return printToClientPacket("Last system condition downloaded successful")[0]
        } catch (_: Exception) {
            return printToClientPacket("Can't found info about last system condition. Will use default serialization strategy and default collection type.")[0]
        }
    }

    private fun downloadCollection(collectionManager: CollectionManager): Boolean {
        try {
            val file = File(collectionManager.getFileName())
            val reader = InputStreamReader(file.inputStream())
            collectionManager.collection = serializator.deserialize(reader.readText(), collectionManager.collection)
        } catch (_: Exception) {
            return false
        }
        return true
    }

}