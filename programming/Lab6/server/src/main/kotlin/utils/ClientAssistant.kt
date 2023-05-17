package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ClientAssistant: KoinComponent {
    private val serializator: Serializator by inject()
    private val clientCommandInvoker: ClientCommandInvoker by inject()
    var collectionManager = CollectionManager()
    init {
        //download last system condition
    }

    fun executeQuery(message: String) : String {
        val argumentPacket = deserializeMessage(message)
        val out = clientCommandInvoker.invoke(argumentPacket)
        return serializeMessage(out)
    }

    fun serializeMessage(packet: Packet) : String {
        return serializator.serialize(packet)
    }

    fun deserializeMessage(message: String) : Packet {
        return serializator.deserialize(message, Packet())
    }
}
